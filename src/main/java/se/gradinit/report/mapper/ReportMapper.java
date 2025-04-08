package se.gradinit.report.mapper;

import se.gradinit.report.dao.ReportEntity;
import se.gradinit.report.model.Report;

public class ReportMapper {
    public static ReportEntity map(Report report) {
        if (report == null) {
            return null;
        }
        return ReportEntity.builder()
                .id(report.getId())
                .blindId(report.getBlindId())
                .clear(report.getClear())
                .move(report.getMove())
                .repair(report.getRepair())
                .build();
    }

    public static Report map(ReportEntity reportEntity) {
        if (reportEntity == null) {
            return null;
        }
        return Report.builder()
                .id(reportEntity.getId())
                .blindId(reportEntity.getBlindId())
                .clear(reportEntity.getClear())
                .move(reportEntity.getMove())
                .repair(reportEntity.getRepair())
                .build();
    }
}
