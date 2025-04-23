package se.gradinit.observation.service;

import org.springframework.stereotype.Service;
import se.gradinit.observation.dao.ObservationRepository;
import se.gradinit.observation.mapper.ObservationMapper;
import se.gradinit.observation.model.Observation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ObservationService {
    private final ObservationRepository observationRepository;
    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public Observation createObservation(Observation observation) {
        return ObservationMapper.map(observationRepository.save(ObservationMapper.map(observation)));
    }

    public void deleteObservationById(Long id) {
        observationRepository.deleteById(id);
    }

    public Optional<Observation> findObservationById(Long id) {
        return observationRepository.findById(id)
                .map(ObservationMapper::map);
    }

    public Optional<Observation> updateObservation(Long id, Observation updatedObservation) {
        return observationRepository.findById(id)
                .map(existingObservation -> {
                    if (updatedObservation.getBlindId() != null) {
                        existingObservation.setBlindId(updatedObservation.getBlindId());
                    }
                    if (updatedObservation.getAnimal() != null) {
                        existingObservation.setAnimal(updatedObservation.getAnimal());
                    }
                    if (updatedObservation.getCount() != null) {
                        existingObservation.setCount(updatedObservation.getCount());
                    }
                    if (updatedObservation.getDate() != null) {
                        existingObservation.setDate(updatedObservation.getDate());
                    }
                    return ObservationMapper.map(observationRepository.save(existingObservation));
                });
    }

    public List<Observation> getAllObservations() {
        return observationRepository.findAll().stream()
                .map(ObservationMapper::map)
                .toList();
    }

    public List<Observation> getObservationsByDate(LocalDate date) {
        return observationRepository.findByDate(date).stream()
                .map(ObservationMapper::map)
                .toList();
    }
}
