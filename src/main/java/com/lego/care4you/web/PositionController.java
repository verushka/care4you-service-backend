package com.lego.care4you.web;

import com.lego.care4you.domain.Position;
import com.lego.care4you.dto.PositionRequestDTO;
import com.lego.care4you.service.PositionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/positions")
@Api(value = "positions", description = "Operations related to positions")
public class PositionController {

    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Position> findAll() {
        return positionService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Position findById(@PathVariable String id) {
        return positionService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Position insert(@RequestBody PositionRequestDTO dto) {
        return positionService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Position delete(@PathVariable String id) {
        return positionService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Position update(@PathVariable String id, @RequestBody PositionRequestDTO dto) {
        return positionService.update(id, dto);
    }
}
