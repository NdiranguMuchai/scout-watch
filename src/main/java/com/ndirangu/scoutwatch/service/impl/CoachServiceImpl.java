package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.repostiory.CoachRepository;
import com.ndirangu.scoutwatch.service.CoachService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CoachServiceImpl implements CoachService {
    private CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Set<Coach> findAll() {
        return null;
    }

    @Override
    public Coach findById(Long aLong) {
        return null;
    }

    @Override
    public Coach save(Coach object) {
        return null;
    }

    @Override
    public void delete(Coach object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
