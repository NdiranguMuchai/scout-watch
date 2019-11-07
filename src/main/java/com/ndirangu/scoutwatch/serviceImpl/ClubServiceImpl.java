package com.ndirangu.scoutwatch.serviceImpl;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Country;
import com.ndirangu.scoutwatch.repostiory.ClubRepository;
import com.ndirangu.scoutwatch.service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl  implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }


    @Override
    public Page<Club> listAll(Pageable pageable) {
        return clubRepository.findAll(pageable);
    }
}
