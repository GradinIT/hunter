package se.gradinit.blind.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import se.gradinit.area.model.Area;

@Builder
@Getter
@Setter
public class Blind {
    private Long id;
    private String description;
    private String type;
    private Area area;
}
