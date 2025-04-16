package se.gradinit.lottery;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.blind.service.BlindService;
import se.gradinit.hunter.service.HunterService;
import se.gradinit.lottery.model.LotteryPair;
import se.gradinit.lottery.model.LotteryRequest;
import se.gradinit.lottery.model.LotteryResponse;

import java.util.Collections;

@RestController
public class LotteryControl {
    private final HunterService hunterService;
    private final BlindService blindService;

    public LotteryControl(HunterService hunterService, BlindService blindService) {
        this.hunterService = hunterService;
        this.blindService = blindService;
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
}
