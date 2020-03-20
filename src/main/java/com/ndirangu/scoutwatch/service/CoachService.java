package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CoachService {
    Page<Coach> list(Pageable pageable);
    Optional<Coach> findOne(UUID id) throws Exception;
    UUID create(Coach coach) throws Exception;
    UUID update(Coach coach) throws Exception;
    UUID delete(Coach coach) throws Exception;
}
