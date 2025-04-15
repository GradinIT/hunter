package se.gradinit.observation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Observation {
    private Long id;
    private Long blindId;
    private String animal;
    private Long count;
}
