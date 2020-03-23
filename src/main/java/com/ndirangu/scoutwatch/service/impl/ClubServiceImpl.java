package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.repository.ClubRepository;;
import com.ndirangu.scoutwatch.service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Page<Club> list(Pageable pageable) {
        return clubRepository.findAll(pageable);
    }

    @Override
    public Optional<Club> findOne(UUID id) throws Exception {
        clubRepository.findById(id).orElseThrow(()-> new Exception("club with id "+id+" not found"));
        return clubRepository.findById(id);
    }

    @Override
    public UUID create(Club club) throws Exception {
        if (club.getCoach().getId() == null){
            throw new Exception("Coach property is required");
        }
        return clubRepository.save(club).getId();
    }

    @Override
    public UUID update(Club club) throws Exception {
        clubRepository.findById(club.getId()).orElseThrow(()-> new Exception("club with id "+club.getId()+" not found"));
        club.setId(club.getId());
        club.setCoach(club.getCoach());
        return clubRepository.save(club).getId();
    }

    @Override
    public UUID delete(Club club) throws Exception {
        return null;
    }
}
