package se.gradinit.report.service;

import org.springframework.stereotype.Service;
import se.gradinit.report.dao.ReportRepository;
import se.gradinit.report.mapper.ReportMapper;
import se.gradinit.report.model.Report;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report createReport(Report report) {
        return ReportMapper.map(reportRepository.save(ReportMapper.map(report)));
    }

    public Optional<Report> updateReport(Long id, Report updatedReport) {
        return reportRepository.findById(id).map(existingReport -> {
            if (updatedReport.getBlindId() != null) {
                existingReport.setBlindId(updatedReport.getBlindId());
            }
            if (updatedReport.getClear() != null) {
                existingReport.setClear(updatedReport.getClear());
            }
            if (updatedReport.getMove() != null) {
                existingReport.setMove(updatedReport.getMove());
            }
            if (updatedReport.getRepair() != null) {
                existingReport.setRepair(updatedReport.getRepair());
            }
            return ReportMapper.map(reportRepository.save(existingReport));
        });
    }

    public void deleteReportById(Long id) {
        reportRepository.deleteById(id);
    }

    public Optional<Report> findReportById(Long id) {
        return reportRepository.findById(id).map(ReportMapper::map);
    }

    public List<Report> findAllReports() {
        return reportRepository.findAll().stream()
                .map(ReportMapper::map)
                .toList();
    }

}
