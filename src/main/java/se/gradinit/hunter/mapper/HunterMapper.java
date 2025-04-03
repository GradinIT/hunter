package se.gradinit.hunter.mapper;

import se.gradinit.hunter.dao.HunterEntity;
import se.gradinit.area.mapper.AreaMapper;
import se.gradinit.hunter.model.Hunter;

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
