package se.gradinit.area.service;

import org.springframework.stereotype.Service;
import se.gradinit.area.dao.AreaRepository;

@Service
public class AreaService {
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
}
