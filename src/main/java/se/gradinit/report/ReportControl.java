package se.gradinit.report;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.report.model.Report;
import se.gradinit.report.service.ReportService;

import java.util.List;
import java.util.Optional;

@RestController
public class ReportControl {
    private final ReportService reportService;
    public ReportControl(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/report")
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        return ResponseEntity.ok().body(reportService.createReport(report));
    }

    @PutMapping("/report/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable("id") Long id, @RequestBody Report report) {
        Optional<Report> updatedReport = reportService.updateReport(id, report);
        if (updatedReport.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedReport.get());
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<Report> getReport(@PathVariable("id") Long id) {
        Optional<Report> report = reportService.findReportById(id);
        if (report.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(report.get());
    }

    @DeleteMapping("/report/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable("id") Long id) {
        reportService.deleteReportById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getReports() {
        return ResponseEntity.ok(reportService.findAllReports());
    }
}
