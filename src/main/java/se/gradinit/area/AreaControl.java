package se.gradinit.area;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.area.model.Area;
import se.gradinit.area.service.AreaService;

import java.util.List;
import java.util.Optional;

@RestController
public class AreaControl {
    private final AreaService areaService;

    public AreaControl(AreaService areaService) {
        this.areaService = areaService;
    }
    @GetMapping("/area")
    public ResponseEntity<List<Area>> getAreas() {
        return ResponseEntity.ok(areaService.getAreas());
    }

    @PostMapping("/area")
    public ResponseEntity<Area> createArea(@RequestBody Area area) {
        return ResponseEntity.ok().body(areaService.createArea(area));
    }

    @PutMapping("/area/{id}")
    public ResponseEntity<Area> updateArea(@PathVariable("id") Long id, @RequestBody Area area) {
        Optional<Area> updatedArea = areaService.updateArea(id, area);
        if (updatedArea.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedArea.get());
    }

    @GetMapping("/area/{id}")
    public ResponseEntity<Area> getArea(@PathVariable("id") Long id) {
        Optional<Area> Area = areaService.findAreaById(id);
        if (Area.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Area.get());
    }

    @DeleteMapping("/area/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable("id") Long id) {
        areaService.deleteAreaById(id);
        return ResponseEntity.noContent().build();
    }

}
