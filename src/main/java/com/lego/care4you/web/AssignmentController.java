package com.lego.care4you.web;

import com.lego.care4you.domain.Assignment;
import com.lego.care4you.dto.AssignmentRequestDTO;
import com.lego.care4you.service.AssignmentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/assignments")
@Api(value = "assignments", description = "Operations related to assignments")
public class AssignmentController {

    private AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Assignment> findAll() {
        return assignmentService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Assignment findById(@PathVariable String id) {
        return assignmentService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Assignment insert(@RequestBody AssignmentRequestDTO dto) {
        return assignmentService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Assignment delete(@PathVariable String id) {
        return assignmentService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Assignment update(@PathVariable String id, @RequestBody AssignmentRequestDTO dto) {
        return assignmentService.update(id, dto);
    }
}
