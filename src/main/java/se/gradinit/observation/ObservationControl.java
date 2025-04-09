package se.gradinit.observation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.gradinit.observation.model.Observation;
import se.gradinit.observation.service.ObservationService;

import java.util.List;
import java.util.Optional;

@RestController
public class ObservationControl {
    private final ObservationService observationService;
    ObservationControl(ObservationService observationService) {
        this.observationService = observationService;
    }

    @PostMapping("/observation")
    public ResponseEntity<Observation> createObservation(@RequestBody Observation observation) {
        return ResponseEntity.ok().body(observationService.createObservation(observation));
    }

    @PutMapping("/observation/{id}")
    public ResponseEntity<Observation> updateObservation(@PathVariable("id") Long id, @RequestBody Observation observation) {
        Optional<Observation> updatedObservation = observationService.updateObservation(id, observation);
        if (updatedObservation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedObservation.get());
    }

    @GetMapping("/observation/{id}")
    public ResponseEntity<Observation> getObservation(@PathVariable("id") Long id) {
        Optional<Observation> observation = observationService.findObservationById(id);
        if (observation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(observation.get());
    }

    @DeleteMapping("/observation/{id}")
    public ResponseEntity<Void> deleteObservation(@PathVariable("id") Long id) {
        observationService.deleteObservationById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/observations")
    public List<Observation> getAllObservations() {
        return observationService.getAllObservations();
    }
}
