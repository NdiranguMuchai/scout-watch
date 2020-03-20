package com.ndirangu.scoutwatch.repository;

import com.ndirangu.scoutwatch.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PositionRepository extends JpaRepository<Position, UUID> {
}
