package com.lego.care4you.web;

import com.lego.care4you.domain.SafetyEquipment;
import com.lego.care4you.dto.SafetyEquipmentRequestDTO;
import com.lego.care4you.service.SafetyEquipmentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/safetyEquipments")
@Api(value = "safetyEquipments", description = "Operations related to safetyEquipments")
public class SafetyEquipmentController {

    private SafetyEquipmentService safetyEquipmentService;

    public SafetyEquipmentController(SafetyEquipmentService safetyEquipmentService) {
        this.safetyEquipmentService = safetyEquipmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SafetyEquipment> findAll() {
        return safetyEquipmentService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public SafetyEquipment findById(@PathVariable String id) {
        return safetyEquipmentService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public SafetyEquipment insert(@RequestBody SafetyEquipmentRequestDTO dto) {
        return safetyEquipmentService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public SafetyEquipment delete(@PathVariable String id) {
        return safetyEquipmentService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public SafetyEquipment update(@PathVariable String id, @RequestBody SafetyEquipmentRequestDTO dto) {
        return safetyEquipmentService.update(id, dto);
    }
}
