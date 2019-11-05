package com.ndirangu.scoutwatch.serviceImpl;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.repostiory.ClubRepository;
import com.ndirangu.scoutwatch.service.ClubService;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl  implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Long create(Club club) throws Exception {
        return clubRepository.save(club).getId();
    }
}
