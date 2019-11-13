package com.ndirangu.scoutwatch.serviceImpl;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.repostiory.ClubRepository;
import com.ndirangu.scoutwatch.service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClubServiceImpl  implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Optional<Club> findOne(Long id) {
        return clubRepository.findById(id);
    }

    @Override
    public Long update(Club club) throws Exception {
        clubRepository.findById(club.getId()).orElseThrow(() -> new Exception("club with id "+club.getId()+" not found"));
        return clubRepository.save(club).getId();
    }

    @Override
    public Long create(Club club) {
        return clubRepository.save(club).getId();
    }

    @Override
    public Page<Club> listAll(Pageable pageable) {
        return clubRepository.findAll(pageable);
    }
}

