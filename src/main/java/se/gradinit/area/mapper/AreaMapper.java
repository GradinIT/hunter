package se.gradinit.area.mapper;

import se.gradinit.area.dao.AreaEntity;
import se.gradinit.area.model.Area;

public class AreaMapper {
    public static Area map(AreaEntity entity){
        return Area.builder().build();
    }
    public static AreaEntity map(Area area){
        return AreaEntity.builder().build();
    }
}
