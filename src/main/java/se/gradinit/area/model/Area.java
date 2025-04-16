package se.gradinit.area.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// JSON object
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    private Long id;
    private String name;
    private Long manager; // TODO: manager is the id of the Hunter who manages this Area
    private String description;
}
