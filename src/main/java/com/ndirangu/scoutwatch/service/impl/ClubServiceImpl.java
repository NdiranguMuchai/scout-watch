package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.repostiory.ClubRepository;
import com.ndirangu.scoutwatch.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClubServiceImpl  implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Set<Club> findAll() {
        return null;
    }

    @Override
    public Club findById(Long aLong) {
        return null;
    }

    @Override
    public Club save(Club object) {
        return null;
    }

    @Override
    public void delete(Club object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}

