package se.gradinit.hunter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import se.gradinit.area.model.Area;

@Builder
@Getter
@Setter
public class Hunter {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Area area;
}
