package se.gradinit.area.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
