package se.gradinit.observation;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.gradinit.hunter.model.Hunter;
import se.gradinit.hunter.service.HunterService;
import se.gradinit.observation.model.Observation;
import se.gradinit.observation.service.ObservationService;

import java.time.LocalDate;
import java.util.List;

@Component
public class ObservationReportSummaryMessage {
    private final JavaMailSender emailSender;
    private final HunterService hunterService;
    private final ObservationService observationService;
    @Value("${spring.mail.username}")
    private String from;

    public ObservationReportSummaryMessage(JavaMailSender emailSender,
                                           HunterService hunterService,
                                           ObservationService observationService) {
        this.emailSender = emailSender;
        this.hunterService = hunterService;
        this.observationService = observationService;
    }

    @Scheduled(cron = "0 0 20 * * ?")
    public void sendDailyObservationReportSummary() throws MessagingException {
        LocalDate today = LocalDate.now();
        List<Observation> observations = observationService.getObservationsByDate(today);
        StringBuilder text = new StringBuilder("<h1>Daglig observationsrapport sammanfattning</h1>");
        text.append("<p>Datum: ").append(today).append("</p>");
        text.append("<table>");
        text.append("<tr><th>Pass</th><th>Djur</th><th>Antal</th></tr>");
        for (Observation observation : observations) {
            text.append("<tr>");
            text.append("<td>").append(observation.getBlindId()).append("</td>");
            text.append("<td>").append(observation.getAnimal()).append("</td>");
            text.append("<td>").append(observation.getCount()).append("</td>");
            text.append("</tr>");
        }
        text.append("</table>");


        for (Hunter hunter : hunterService.findHuntLeaders()) {
            if (hunter.getEmail() == null) {
                continue;
            }

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setFrom(from);
            helper.setTo(hunter.getEmail());
            helper.setSubject("Observationsrapport " + today);
            helper.setText(text.toString(), true);
            emailSender.send(message);
        }
    }
}
