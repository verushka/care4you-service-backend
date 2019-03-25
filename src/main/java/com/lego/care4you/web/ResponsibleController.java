package com.lego.care4you.web;

import com.lego.care4you.domain.Responsible;
import com.lego.care4you.dto.ResponsibleRequestDTO;
import com.lego.care4you.service.ResponsibleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/responsibles")
@Api(value = "responsibles", description = "Operations related to responsibles")
public class ResponsibleController {

    private ResponsibleService responsibleService;

    public ResponsibleController(ResponsibleService responsibleService) {
        this.responsibleService = responsibleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Responsible> findAll() {
        return responsibleService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Responsible findById(@PathVariable String id) {
        return responsibleService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Responsible insert(@RequestBody ResponsibleRequestDTO dto) {
        return responsibleService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Responsible delete(@PathVariable String id) {
        return responsibleService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Responsible update(@PathVariable String id, @RequestBody ResponsibleRequestDTO dto) {
        return responsibleService.update(id, dto);
    }
}

