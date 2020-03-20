package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Position;
import com.ndirangu.scoutwatch.service.PositionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
    @GetMapping({"","/"})
    public  @ResponseBody
    Page<Position> list(Pageable pageable){
        return positionService.list(pageable);
    }

    @GetMapping("/{positionId}")
    public @ResponseBody
    Optional<Position> findOne(@PathVariable UUID positionId) throws Exception{
        positionService.findOne(positionId).orElseThrow(()-> new Exception("coach with id "+positionId+" not found"));
        return positionService.findOne(positionId);
    }

    @PostMapping("/create")
    public @ResponseBody UUID create(@RequestBody Position position) throws Exception{
        return positionService.create(position);
    }

    @PutMapping("/{positionId}")
    public @ResponseBody UUID update(@RequestBody Position position, @PathVariable UUID positionId) throws Exception{
        positionService.findOne(positionId).orElseThrow(()-> new Exception("coach with id "+positionId+" not found"));
        position.setId(positionId);
        return positionService.update(position);
    }
}
