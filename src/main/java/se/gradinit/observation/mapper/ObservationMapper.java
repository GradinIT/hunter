package se.gradinit.observation.mapper;

import se.gradinit.observation.dao.ObservationEntity;
import se.gradinit.observation.model.Observation;

public class ObservationMapper {
    public static Observation map(ObservationEntity entity) {
        return Observation.builder()
                .id(entity.getId())
                .blindId(entity.getBlindId())
                .animal(entity.getAnimal())
                .count(entity.getCount())
                .build();
    }

    public static ObservationEntity map(Observation observation) {
        return ObservationEntity.builder()
                .id(observation.getId())
                .blindId(observation.getBlindId())
                .animal(observation.getAnimal())
                .count(observation.getCount())
                .build();
    }
}
