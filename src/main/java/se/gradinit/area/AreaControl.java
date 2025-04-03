package se.gradinit.area;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.area.dao.HunterEntity;
import se.gradinit.area.mapper.HunterMapper;
import se.gradinit.area.model.Area;
import se.gradinit.area.model.Hunter;
import se.gradinit.area.service.AreaService;
import se.gradinit.area.service.HunterService;

import java.util.List;

@RestController
public class AreaControl {
    private final AreaService areaService;
    private final HunterService hunterService;

    public AreaControl(AreaService areaService, HunterService hunterService) {
        this.areaService = areaService;
        this.hunterService = hunterService;
    }
    @GetMapping("/area")
    public ResponseEntity<List<Area>> getAreas() {
        return ResponseEntity.ok(areaService.getAreas());
    }

    @GetMapping("/area/{id}")
    public ResponseEntity<List<Hunter>> getHuntersByArea(@PathVariable("id") Long areaId) {
        return ResponseEntity.ok(hunterService.findHuntersByArea(areaId));
    }

    @PostMapping("/hunter")
    public ResponseEntity<Void> createHunter(HunterEntity hunter) {
        hunterService.createHunter(hunter);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hunters")
    public ResponseEntity<List<Hunter>> getHunters() {
        return ResponseEntity.ok(hunterService.findAllHunters());
    }

}
