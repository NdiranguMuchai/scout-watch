package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoachService {
    Page<Coach> listAll(Pageable pageable);
}
