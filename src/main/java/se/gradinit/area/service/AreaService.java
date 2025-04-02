package se.gradinit.area.service;

import org.springframework.stereotype.Service;
import se.gradinit.area.dao.AreaRepository;
import se.gradinit.area.mapper.AreaMapper;
import se.gradinit.area.model.Area;

import java.util.List;

@Service
public class AreaService {
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<Area> getAreas() {
        return areaRepository.findAll().stream().map(AreaMapper::map).toList();
    }
}
