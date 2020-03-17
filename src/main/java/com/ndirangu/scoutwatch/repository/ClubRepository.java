package com.ndirangu.scoutwatch.repository;

import com.ndirangu.scoutwatch.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClubRepository extends JpaRepository<Club, UUID> {
}
