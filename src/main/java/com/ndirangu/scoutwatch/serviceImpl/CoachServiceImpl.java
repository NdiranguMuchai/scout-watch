package com.ndirangu.scoutwatch.serviceImpl;

import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.repostiory.CoachRepository;
import com.ndirangu.scoutwatch.service.CoachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<Coach> findById(Long coachId) throws Exception {
//         coachRepository.findById(coachId).orElseThrow(()-> new Exception("Coach with id"+coachId+" not found"));
         return coachRepository.findById(coachId);
    }

    @Override
    public Long create(Coach coach) {
        return coachRepository.save(coach).getId();
    }
}
