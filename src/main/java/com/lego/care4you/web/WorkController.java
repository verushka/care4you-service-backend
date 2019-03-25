package com.lego.care4you.web;

import com.lego.care4you.domain.Work;
import com.lego.care4you.dto.WorkRequestDTO;
import com.lego.care4you.service.WorkService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/works")
@Api(value = "works", description = "Operations related to works")
public class WorkController {

    private WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Work> findAll() {
        return workService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Work findById(@PathVariable String id) {
        return workService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Work insert(@RequestBody WorkRequestDTO dto) {
        return workService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Work delete(@PathVariable String id) {
        return workService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Work update(@PathVariable String id, @RequestBody WorkRequestDTO dto) {
        return workService.update(id, dto);
    }
}

