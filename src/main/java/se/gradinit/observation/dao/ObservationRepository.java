package se.gradinit.observation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ObservationRepository extends JpaRepository<ObservationEntity, Long> {
    List<ObservationEntity> findByDate(LocalDate date);
}
