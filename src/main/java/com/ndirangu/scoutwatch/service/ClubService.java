package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClubService {
    Page<Club> listAll(Pageable pageable);
    Optional<Club> findOne(Long id);
    Long create(Club club);
    Long update(Club club) throws Exception;

}
