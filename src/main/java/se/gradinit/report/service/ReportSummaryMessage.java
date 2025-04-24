package se.gradinit.report.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import se.gradinit.area.service.AreaService;
import se.gradinit.blind.service.BlindService;
import se.gradinit.hunter.service.HunterService;
import se.gradinit.report.model.Report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ReportSummaryMessage {
    private final JavaMailSender emailSender;
    private final HunterService hunterService;
    private final AreaService areaService;
    private final BlindService blindService;
    private final ReportService reportService;
    @Value("${spring.mail.username}")
    private String from;

    public ReportSummaryMessage(JavaMailSender emailSender,
                                AreaService areaService,
                                HunterService hunterService,
                                BlindService blindService,
                                ReportService reportService) {
        this.emailSender = emailSender;
        this.hunterService = hunterService;
        this.areaService = areaService;
        this.blindService = blindService;
        this.reportService = reportService;
    }

    public void sendAreaManagerMessage() throws MessagingException {
        // Get all reports and group them by area
        var reportsByArea = new HashMap<Long, List<Report>>();
        for (var report : reportService.findAllReports()) {
            var blind = blindService.findBlindById(report.getBlindId());
            if (blind.isEmpty() || blind.get().getAreaId() == null) {
                continue;
            }
            reportsByArea.computeIfAbsent(blind.get().getAreaId(), k -> new ArrayList<>()).add(report);
        }

        // Send email to each area manager with the reports for their area
        for (Long areaId : reportsByArea.keySet()) {
            var area = areaService.findAreaById(areaId);
            if (area.isEmpty() || area.get().getManager() == null) {
                continue;
            }
            var manager = hunterService.findHunterById(area.get().getManager());
            if (manager.isEmpty() || manager.get().getEmail() == null) {
                continue;
            }

            var text = new StringBuilder("""
                    <h1>Rapporter</h1>
                    <table>
                    <tr><th>Pass</th><th>Såt</th><th>Lagas</th><th>Flytta</th><th>Rensa</th></tr>
                    """);
            for (var report : reportsByArea.get(areaId)) {
                String blindDescription = report.getBlindId().toString();
                var blind = blindService.findBlindById(report.getBlindId());
                if (blind.isPresent()) {
                    blindDescription = blind.get().getDescription();
                }

                text.append("<tr>");
                text.append("<td>").append(blindDescription).append("</td>");
                text.append("<td>").append(area.get().getName()).append("</td>");
                text.append("<td>").append(report.getRepair()).append("</td>");
                text.append("<td>").append(report.getMove() ? "Ja" : "Nej").append("</td>");
                text.append("<td>").append(report.getClear() ? "Ja" : "Nej").append("</td>");
                text.append("</tr>\n");
            }
            text.append("</table>");
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setFrom(from);
            helper.setTo(manager.get().getEmail());
            helper.setSubject("Rapporter från " + area.get().getName());
            helper.setText(text.toString(), true);
            emailSender.send(message);
        }
    }
}
