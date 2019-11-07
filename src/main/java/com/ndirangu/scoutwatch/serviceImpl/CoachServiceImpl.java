package com.ndirangu.scoutwatch.serviceImpl;

import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.repostiory.CoachRepository;
import com.ndirangu.scoutwatch.service.CoachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService {
    private CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Page<Coach> listAll(Pageable pageable) {
        return coachRepository.findAll(pageable);
    }
}
