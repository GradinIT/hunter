package se.gradinit.hunter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HunterRepository extends JpaRepository<HunterEntity, Long> {
    @Query("SELECT h FROM HunterEntity h WHERE h.leader = true")
    List<HunterEntity> findHunterLeaders();
}
