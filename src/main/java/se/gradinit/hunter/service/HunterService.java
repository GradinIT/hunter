package se.gradinit.hunter.service;

import org.springframework.stereotype.Service;
import se.gradinit.hunter.dao.HunterEntity;
import se.gradinit.hunter.dao.HunterRepository;
import se.gradinit.hunter.mapper.HunterMapper;
import se.gradinit.hunter.model.Hunter;

import java.util.List;

@Service
public class HunterService {
    private final HunterRepository hunterRepository;
    public HunterService(HunterRepository hunterRepository) {
        this.hunterRepository = hunterRepository;
    }

    public void createHunter(HunterEntity hunter) {
        hunterRepository.save(hunter);
    }

    public List<Hunter> findHuntersByArea(Long areaId) {
        return hunterRepository.findAll().stream()
                .filter(hunter -> hunter.getArea().getId().equals(areaId))
                .map(HunterMapper::map)
                .toList();
    }

    public List<Hunter> findAllHunters() {
        return hunterRepository.findAll().stream()
                .map(HunterMapper::map)
                .toList();
    }
}
