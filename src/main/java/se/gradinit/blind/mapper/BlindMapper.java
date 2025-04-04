package se.gradinit.blind.mapper;

import se.gradinit.blind.dao.BlindEntity;
import se.gradinit.area.mapper.AreaMapper;
import se.gradinit.blind.model.Blind;

public class BlindMapper {
    public static Blind map(BlindEntity blind) {
        return Blind.builder()
                .id(blind.getId())
                .description(blind.getDescription())
                .type(blind.getType())
                .areaId(blind.getAreaId())
                .build();
    }

    public static BlindEntity map(Blind blind) {
        return BlindEntity.builder()
                .id(blind.getId())
                .description(blind.getDescription())
                .type(blind.getType())
                .areaId(blind.getAreaId())
                .build();
    }
}
