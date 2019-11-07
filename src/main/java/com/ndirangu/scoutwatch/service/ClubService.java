package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClubService {
    Page<Club> listAll(Pageable pageable);

}
