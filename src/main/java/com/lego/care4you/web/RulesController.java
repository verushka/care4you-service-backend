package com.lego.care4you.web;

import com.lego.care4you.domain.Rule;
import com.lego.care4you.dto.RulesRequestDTO;
import com.lego.care4you.service.RuleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rules")
@Api(value = "rules", description = "Operations related to rules")
public class RulesController {

    private RuleService ruleService;

    public RulesController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Rule> findAll() {
        return ruleService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Rule findById(@PathVariable String id) {
        return ruleService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Rule insert(@RequestBody RulesRequestDTO dto) {
        return ruleService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Rule delete(@PathVariable String id) {
        return ruleService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Rule update(@PathVariable String id, @RequestBody RulesRequestDTO dto) {
        return ruleService.update(id, dto);
    }
}
