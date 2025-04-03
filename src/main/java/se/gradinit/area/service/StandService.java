package se.gradinit.area.service;

import org.springframework.stereotype.Service;
import se.gradinit.area.dao.StandRepository;
import se.gradinit.area.mapper.StandMapper;
import se.gradinit.area.model.Stand;

import java.util.List;

@Service
public class StandService {
    private final StandRepository standRepository;
    public StandService(StandRepository standRepository) {
        this.standRepository = standRepository;
    }

    public List<Stand> findStandsByArea(Long areaId) {
        return standRepository.findAll().stream()
                .filter(stand -> stand.getArea().getId().equals(areaId))
                .map(StandMapper::map)
                .toList();
    }

    public List<Stand> findAllStands() {
        return standRepository.findAll().stream()
                .map(StandMapper::map)
                .toList();
    }
}
