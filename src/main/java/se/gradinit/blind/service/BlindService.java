package se.gradinit.blind.service;

import org.springframework.stereotype.Service;
import se.gradinit.blind.dao.BlindRepository;
import se.gradinit.blind.mapper.BlindMapper;
import se.gradinit.blind.model.Blind;

import java.util.List;
import java.util.Optional;

@Service
public class BlindService {
    private final BlindRepository blindRepository;
    public BlindService(BlindRepository blindRepository) {
        this.blindRepository = blindRepository;
    }

    public Blind createBlind(Blind blind) {
        return BlindMapper.map(blindRepository.save(BlindMapper.map(blind)));
    }

    public Optional<Blind> updateBlind(Long id, Blind updatedBlind) {
        return blindRepository.findById(id).map(existingBlind -> {
            if (updatedBlind.getDescription() != null) {
                existingBlind.setDescription(updatedBlind.getDescription());
            }
            if (updatedBlind.getType() != null) {
                existingBlind.setType(updatedBlind.getType());
            }
            if (updatedBlind.getAreaId() != null) {
                existingBlind.setAreaId(updatedBlind.getAreaId());
            }
            return BlindMapper.map(blindRepository.save(existingBlind));
        });
    }

    public void deleteBlindById(Long id) {
        blindRepository.deleteById(id);
    }

    public Optional<Blind> findBlindById(Long id) {
        return blindRepository.findById(id).map(BlindMapper::map);
    }

    public List<Blind> findAllBlinds() {
        return blindRepository.findAll().stream()
                .map(BlindMapper::map)
                .toList();
    }
}
