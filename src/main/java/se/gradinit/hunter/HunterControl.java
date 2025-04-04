package se.gradinit.hunter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.hunter.dao.HunterEntity;
import se.gradinit.hunter.mapper.HunterMapper;
import se.gradinit.hunter.model.Hunter;
import se.gradinit.hunter.service.HunterService;

import java.util.List;
import java.util.Optional;

@RestController
public class HunterControl {
    private final HunterService hunterService;
    HunterControl(HunterService hunterService) {
        this.hunterService = hunterService;
    }

    @PostMapping("/hunter")
    public ResponseEntity<Hunter> createHunter(@RequestBody Hunter hunter) {
        return ResponseEntity.ok().body(hunterService.createHunter(hunter));
    }

    @PutMapping("/hunter/{id}")
    public ResponseEntity<Hunter> updateHunter(@PathVariable("id") Long id, @RequestBody Hunter hunter) {
        Optional<Hunter> updatedHunter = hunterService.updateHunter(id, hunter);
        if (updatedHunter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedHunter.get());
    }

    @GetMapping("/hunter/{id}")
    public ResponseEntity<Hunter> getHunter(@PathVariable("id") Long id) {
        Optional<Hunter> hunter = hunterService.findHunterById(id);
        if (hunter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hunter.get());
    }

    @DeleteMapping("/hunter/{id}")
    public ResponseEntity<Void> deleteHunter(@PathVariable("id") Long id) {
        hunterService.deleteHunterById(id);
        return ResponseEntity.noContent().build();
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
