package se.gradinit.area.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Stand {
    private Long id;
    private String description;
    private String type;
    private Area area;
}
