package se.gradinit.hunter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hunter {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Long areaId; // TODO: this is the Area that the hunter is a member of Not manager for
}
