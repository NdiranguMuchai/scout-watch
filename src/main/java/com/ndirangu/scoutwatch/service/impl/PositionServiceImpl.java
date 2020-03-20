package com.ndirangu.scoutwatch.service.impl;

import com.ndirangu.scoutwatch.model.Position;
import com.ndirangu.scoutwatch.repository.PositionRepository;
import com.ndirangu.scoutwatch.service.PositionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public Page<Position> list(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public Optional<Position> findOne(UUID id) throws Exception {
        positionRepository.findById(id).orElseThrow(()-> new Exception("position with id "+id+" not found"));
        return positionRepository.findById(id);
    }

    @Override
    public UUID create(Position position) throws Exception {
        return positionRepository.save(position).getId();
    }

    @Override
    public UUID update(Position position) throws Exception {
        positionRepository.findById(position.getId()).orElseThrow(()-> new Exception("position with id "+position.getId()+" not found"));
        position.setId(position.getId());
        return positionRepository.save(position).getId();
    }

    @Override
    public UUID delete(Position position) throws Exception {
        return null;
    }
}
