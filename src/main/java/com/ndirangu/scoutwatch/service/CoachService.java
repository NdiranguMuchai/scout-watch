package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CoachService {
    Page<Coach> listAll(Pageable pageable);
    Optional<Coach> findById(Long coachId) throws Exception;
    Long create(Coach coach);
}
