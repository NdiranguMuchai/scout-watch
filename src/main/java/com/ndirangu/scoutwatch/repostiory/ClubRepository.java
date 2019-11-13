package com.ndirangu.scoutwatch.repostiory;

import com.ndirangu.scoutwatch.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findById(Long id);
}
