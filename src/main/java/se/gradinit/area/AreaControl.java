package se.gradinit.area;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.area.model.Area;
import se.gradinit.area.service.AreaService;

import java.util.List;

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

}
