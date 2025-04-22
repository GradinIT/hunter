package se.gradinit.lottery;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.blind.service.BlindService;
import se.gradinit.lottery.service.LotteryEmailService;
import se.gradinit.hunter.service.HunterService;
import se.gradinit.lottery.model.LotteryPair;
import se.gradinit.lottery.model.LotteryRequest;
import se.gradinit.lottery.model.LotteryResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
public class LotteryControl {
    private final HunterService hunterService;
    private final BlindService blindService;
    private final LotteryEmailService lotteryEmailService;

    public LotteryControl(HunterService hunterService, BlindService blindService,
                          LotteryEmailService lotteryEmailService) {
        this.hunterService = hunterService;
        this.blindService = blindService;
        this.lotteryEmailService = lotteryEmailService;
    }

    @PostMapping("/lottery")
    public ResponseEntity<LotteryResponse> lottery(@RequestBody LotteryRequest request) {
        var hunters = request.getHunters();
        var blinds = request.getBlinds();
        LotteryResponse response = new LotteryResponse();
        if (hunters == null || blinds == null) {
            return ResponseEntity.badRequest().build();
        }

        if (hunters.size() != blinds.size()) {
            return ResponseEntity.badRequest().build();
        }

        Collections.shuffle(blinds);
        Collections.shuffle(hunters);

        for (int i = 0; i < hunters.size(); i++) {
            var existingHunter = hunterService.findHunterById(hunters.get(i));
            var existingBlind = blindService.findBlindById(blinds.get(i));
            if (existingHunter.isEmpty() || existingBlind.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            LotteryPair pair = LotteryPair.builder()
                    .hunter(existingHunter.get())
                    .blind(existingBlind.get())
                    .build();
            response.getPairs().add(pair);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/lottery/notify")
    public ResponseEntity<Void> notifyHunters(@RequestBody LotteryResponse response) {
        if (response.getPairs() == null || response.getPairs().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        StringBuilder lotteryResultTable = new StringBuilder("""
                <h1>Passlottning</h1>
                <table>
                <tr>
                <th>Jägare</th>
                <th>Pass</th>
                </tr>
                """);

        List<String> hunterEmails = new ArrayList<>();
        for (LotteryPair pair : response.getPairs()) {
            var hunter = hunterService.findHunterById(pair.getHunter().getId());
            var blind = blindService.findBlindById(pair.getBlind().getId());
            if (hunter.isEmpty() || blind.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            lotteryResultTable.append("<tr>\n");
            lotteryResultTable.append("<td>").append(hunter.get().getName()).append("</td>\n");
            lotteryResultTable.append("<td>").append(blind.get().getDescription()).append("</td>\n");
            lotteryResultTable.append("</tr>\n");

            if (hunter.get().getEmail() != null) {
                hunterEmails.add(hunter.get().getEmail());
            }
        }
        lotteryResultTable.append("</table>\n");

        for (String email : hunterEmails) {
            try {
                lotteryEmailService.sendMimeMessage(email, "Passlottaren", lotteryResultTable.toString());
            } catch (MessagingException e) {
                log.warn("Failed to send email to {}: {}", email, e.getMessage());
            }
        }

        return ResponseEntity.ok().build();
    }
}
