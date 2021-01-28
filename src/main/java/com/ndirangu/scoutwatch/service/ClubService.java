package com.ndirangu.scoutwatch.service;

import com.ndirangu.scoutwatch.model.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ClubService {
    Page<Club> list(Pageable pageable);
    Optional<Club> findOne(UUID id) throws Exception;
    UUID create(Club club) ;
    UUID update(Club club) throws Exception;
    UUID delete(Club club) throws Exception;
    UUID assignCoach(UUID coachId, Club club) throws Exception;
}
