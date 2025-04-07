package se.gradinit.hunter.service;

import org.springframework.stereotype.Service;
import se.gradinit.hunter.dao.HunterEntity;
import se.gradinit.hunter.dao.HunterRepository;
import se.gradinit.hunter.mapper.HunterMapper;
import se.gradinit.hunter.model.Hunter;

import java.util.List;
import java.util.Optional;

@Service
public class HunterService {
    private final HunterRepository hunterRepository;
    public HunterService(HunterRepository hunterRepository) {
        this.hunterRepository = hunterRepository;
    }

    public Hunter createHunter(Hunter hunter) {
        return HunterMapper.map(hunterRepository.save(HunterMapper.map(hunter)));
    }

    public Optional<Hunter> updateHunter(Long id, Hunter updatedHunter) {
        return hunterRepository.findById(id).map(existingHunter -> {
            if (updatedHunter.getName() != null) {
                existingHunter.setName(updatedHunter.getName());
            }
            if (updatedHunter.getEmail() != null) {
                existingHunter.setEmail(updatedHunter.getEmail());
            }
            if (updatedHunter.getPhone() != null) {
                existingHunter.setPhone(updatedHunter.getPhone());
            }
            if (updatedHunter.getAreaId() != null) {
                existingHunter.setAreaId(updatedHunter.getAreaId());
            }
            return HunterMapper.map(hunterRepository.save(existingHunter));
        });
    }


    public void deleteHunterById(Long id) {
        hunterRepository.deleteById(id);
    }

    public Optional<Hunter> findHunterById(Long id) {
        return hunterRepository.findById(id).map(HunterMapper::map);
    }

    public List<Hunter> findHuntersByArea(Long areaId) {
        return hunterRepository.findAll().stream()
                .filter((hunter) ->
                    hunter.getAreaId() != null && hunter.getAreaId().equals(areaId))
                .map(HunterMapper::map)
                .toList();
    }

    public List<Hunter> findAllHunters() {
        return hunterRepository.findAll().stream()
                .map(HunterMapper::map)
                .toList();
    }
}
