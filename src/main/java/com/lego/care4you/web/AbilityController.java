package com.lego.care4you.web;

import com.lego.care4you.domain.Ability;
import com.lego.care4you.dto.AbilityRequestDTO;
import com.lego.care4you.service.AbilityService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/abilities")
@Api(value = "abilities", description = "Operations related to abilities")
public class AbilityController {

    private AbilityService abilityService;

    public AbilityController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Ability> findAll() {
        return abilityService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Ability findById(@PathVariable String id) {
        return abilityService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ability insert(@RequestBody AbilityRequestDTO dto) {
        return abilityService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Ability delete(@PathVariable String id) {
        return abilityService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Ability update(@PathVariable String id, @RequestBody AbilityRequestDTO dto) {
        return abilityService.update(id, dto);
    }
}
