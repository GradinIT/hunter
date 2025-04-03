package se.gradinit.area.mapper;

import se.gradinit.area.dao.StandEntity;
import se.gradinit.area.model.Stand;

public class StandMapper {
    public static Stand map(StandEntity stand) {
        return Stand.builder()
                .id(stand.getId())
                .build();
    }

    public static StandEntity map(Stand stand) {
        return StandEntity.builder()
                .id(stand.getId())
                .build();
    }
}
