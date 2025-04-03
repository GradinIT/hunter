package se.gradinit.blind;

import org.springframework.web.bind.annotation.RestController;
import se.gradinit.blind.service.BlindService;

@RestController
public class BlindControl {
    private final BlindService blindService;
    public BlindControl(BlindService blindService) {
        this.blindService = blindService;
    }

}
