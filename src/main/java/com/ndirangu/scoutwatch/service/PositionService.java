package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface PositionService {
    Page<Position> list(Pageable pageable);
    Optional<Position> findOne(UUID id) throws Exception;
    UUID create(Position position) throws Exception;
    UUID update(Position position) throws Exception;
    UUID delete(Position position) throws Exception;
}
