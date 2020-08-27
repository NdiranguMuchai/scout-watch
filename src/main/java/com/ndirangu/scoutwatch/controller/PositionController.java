package com.ndirangu.scoutwatch.controller;

import com.ndirangu.scoutwatch.model.Position;
import com.ndirangu.scoutwatch.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Api(tags = "Player Position")
@RestController
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @ApiOperation(value = "Returns a list of all positions")
    @GetMapping({"","/"})
    public  @ResponseBody
    Page<Position> list(Pageable pageable){
        return positionService.list(pageable);
    }

    @ApiOperation(value = "Finds a position based on id")
    @GetMapping("/{positionId}")
    public @ResponseBody
    Optional<Position> findOne(@PathVariable UUID positionId) throws Exception{
        positionService.findOne(positionId).orElseThrow(()-> new Exception("coach with id "+positionId+" not found"));
        return positionService.findOne(positionId);
    }

    @ApiOperation(value = "Creates a position")
    @PostMapping("/create")
    public @ResponseBody UUID create(@RequestBody Position position) throws Exception{
        return positionService.create(position);
    }

    @ApiOperation(value = "Updates a position's details")
    @PutMapping("/{positionId}")
    public @ResponseBody UUID update(@RequestBody Position position, @PathVariable UUID positionId) throws Exception{
        positionService.findOne(positionId).orElseThrow(()-> new Exception("coach with id "+positionId+" not found"));
        position.setId(positionId);
        return positionService.update(position);
    }
}
