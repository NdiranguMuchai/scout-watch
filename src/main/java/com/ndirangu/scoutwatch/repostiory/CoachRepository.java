package com.ndirangu.scoutwatch.repostiory;

import com.ndirangu.scoutwatch.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    Optional<Coach>findById(Long coachId);
}
