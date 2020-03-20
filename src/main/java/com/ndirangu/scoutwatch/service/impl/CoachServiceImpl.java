package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.repository.CoachRepository;
import com.ndirangu.scoutwatch.service.CoachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Page<Coach> list(Pageable pageable) {
        return coachRepository.findAll(pageable);
    }

    @Override
    public Optional<Coach> findOne(UUID id) throws Exception {
        coachRepository.findById(id).orElseThrow(()-> new Exception("coach with id "+id+" not found"));
        return coachRepository.findById(id);
    }

    @Override
    public UUID create(Coach coach) throws Exception {
        return coachRepository.save(coach).getId();
    }

    @Override
    public UUID update(Coach coach) throws Exception {
        coachRepository.findById(coach.getId()).orElseThrow(()-> new Exception("coach with id "+coach.getId()+" not found"));
        coach.setId(coach.getId());

        return coachRepository.save(coach).getId();
    }

    @Override
    public UUID delete(Coach coach) throws Exception {
        return null;
    }
}
