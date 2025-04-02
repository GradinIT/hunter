package se.gradinit.area;

import org.springframework.web.bind.annotation.RestController;
import se.gradinit.area.service.AreaService;
@RestController
public class AreaControl {
    private final AreaService areaService;

    public AreaControl(AreaService areaService) {
        this.areaService = areaService;
    }
}
