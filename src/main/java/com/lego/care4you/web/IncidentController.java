package com.lego.care4you.web;

import com.lego.care4you.domain.Incident;
import com.lego.care4you.dto.IncidentRequestDTO;
import com.lego.care4you.service.IncidentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/incidents")
@Api(value = "incidents", description = "Operations related to incidents")
public class IncidentController {

    private IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Incident> findAll() {
        return incidentService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Incident findById(@PathVariable String id) {
        return incidentService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Incident insert(@RequestBody IncidentRequestDTO dto) {
        return incidentService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Incident delete(@PathVariable String id) {
        return incidentService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Incident update(@PathVariable String id, @RequestBody IncidentRequestDTO dto) {
        return incidentService.update(id, dto);
    }
}
