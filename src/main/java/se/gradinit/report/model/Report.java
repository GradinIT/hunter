package se.gradinit.report.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private Long id;
    private Long blindId;
    private Boolean clear;
    private Boolean move;
    private String repair;
}
