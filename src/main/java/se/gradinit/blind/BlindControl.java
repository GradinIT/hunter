package se.gradinit.blind;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.blind.model.Blind;
import se.gradinit.blind.service.BlindService;

import java.util.List;
import java.util.Optional;

@RestController
public class BlindControl {
    private final BlindService blindService;
    public BlindControl(BlindService blindService) {
        this.blindService = blindService;
    }

    @GetMapping("/blind/{id}")
    public ResponseEntity<Blind> getBlind(@PathVariable("id") Long id) {
        Optional<Blind> blind = blindService.findBlindById(id);
        if (blind.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(blind.get());
    }

    @PostMapping("/blind")
    public ResponseEntity<Blind> createBlind(@RequestBody Blind blind) {
        return ResponseEntity.ok().body(blindService.createBlind(blind));
    }

    @PutMapping("/blind/{id}")
    public ResponseEntity<Blind> updateBlind(@PathVariable("id") Long id, @RequestBody Blind blind) {
        Optional<Blind> existingBlind = blindService.findBlindById(id);
        if (existingBlind.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        blind.setId(id);
        return ResponseEntity.ok().body(blindService.createBlind(blind));
    }

    @DeleteMapping("/blind/{id}")
    public ResponseEntity<Void> deleteBlind(@PathVariable("id") Long id) {
        blindService.deleteBlindById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/blinds")
    public ResponseEntity<List<Blind>> getBlinds() {
        return ResponseEntity.ok(blindService.findAllBlinds());
    }
}
