package se.gradinit.hunter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.hunter.dao.HunterEntity;
import se.gradinit.hunter.model.Hunter;
import se.gradinit.hunter.service.HunterService;

import java.util.List;

@RestController
public class HunterControl {
    private final HunterService hunterService;
    HunterControl(HunterService hunterService) {
        this.hunterService = hunterService;
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

    @GetMapping("/hunter/area/{id}")
    public ResponseEntity<List<Hunter>> getHuntersByArea(@PathVariable("id") Long areaId) {
        return ResponseEntity.ok(hunterService.findHuntersByArea(areaId));
    }

}
