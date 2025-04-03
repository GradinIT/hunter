package se.gradinit.area.mapper;

import se.gradinit.area.dao.HunterEntity;
import se.gradinit.area.model.Hunter;

public class HunterMapper {
    public static Hunter map(HunterEntity hunter) {
        return Hunter.builder()
                .id(hunter.getId())
                .name(hunter.getName())
                .email(hunter.getEmail())
                .phone(hunter.getPhone())
                .area(AreaMapper.map(hunter.getArea()))
                .build();
    }

    public static HunterEntity map(Hunter hunter) {
        return HunterEntity.builder()
                .id(hunter.getId())
                .name(hunter.getName())
                .email(hunter.getEmail())
                .phone(hunter.getPhone())
                .area(AreaMapper.map(hunter.getArea()))
                .build();
    }
}
