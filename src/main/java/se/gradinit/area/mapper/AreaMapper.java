package se.gradinit.area.mapper;

import se.gradinit.area.dao.AreaEntity;
import se.gradinit.area.model.Area;

import java.util.List;

public class AreaMapper {
    public static Area map(AreaEntity area){
        return Area.builder()
                .name(area.getName())
                .id(area.getId())
                .manager(area.getManager())
                .description(area.getDescription())
                .build();
    }
    public static AreaEntity map(Area area){
        return AreaEntity.builder()
                .name(area.getName())
                .id(area.getId())
                .manager(area.getManager())
                .description(area.getDescription())
                .build();
    }
    public static List<Area> map(List<AreaEntity> areas){
        return areas.stream().map(AreaMapper::map).toList();
    }
}
