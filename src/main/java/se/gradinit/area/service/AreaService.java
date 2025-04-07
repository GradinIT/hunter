package se.gradinit.area.service;

import org.springframework.stereotype.Service;
import se.gradinit.area.dao.AreaRepository;
import se.gradinit.area.mapper.AreaMapper;
import se.gradinit.area.model.Area;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<Area> getAreas() {
        return areaRepository.findAll().stream().map(AreaMapper::map).toList();
    }

    public Area createArea(Area area) {
        return AreaMapper.map(areaRepository.save(AreaMapper.map(area)));
    }

    public void deleteAreaById(Long id) {
        areaRepository.deleteById(id);
    }

    public Optional<Area> findAreaById(Long id) {
        return areaRepository.findById(id).map(AreaMapper::map);
    }

    public Optional<Area> updateArea(Long id, Area updatedArea) {
        return areaRepository.findById(id).map(existingArea -> {
            if (updatedArea.getName() != null) {
                existingArea.setName(updatedArea.getName());
            }
            if (updatedArea.getManager() != null) {
                existingArea.setManager(updatedArea.getManager());
            }
            if (updatedArea.getDescription() != null) {
                existingArea.setDescription(updatedArea.getDescription());
            }
            return AreaMapper.map(areaRepository.save(existingArea));
        });
    }
}
