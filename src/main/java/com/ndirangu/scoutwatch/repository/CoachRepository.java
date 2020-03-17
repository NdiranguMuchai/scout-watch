package com.ndirangu.scoutwatch.repository;

import com.ndirangu.scoutwatch.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoachRepository extends JpaRepository<Coach, UUID> {
}
