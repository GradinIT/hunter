package se.gradinit.blind.service;

import org.springframework.stereotype.Service;
import se.gradinit.blind.dao.BlindRepository;
import se.gradinit.blind.mapper.BlindMapper;
import se.gradinit.blind.model.Blind;

import java.util.List;

@Service
public class BlindService {
    private final BlindRepository blindRepository;
    public BlindService(BlindRepository blindRepository) {
        this.blindRepository = blindRepository;
    }

    public List<Blind> findBlindsByArea(Long areaId) {
        return blindRepository.findAll().stream()
                .filter(blind -> blind.getArea().getId().equals(areaId))
                .map(BlindMapper::map)
                .toList();
    }

    public List<Blind> findAllBlinds() {
        return blindRepository.findAll().stream()
                .map(BlindMapper::map)
                .toList();
    }
}
