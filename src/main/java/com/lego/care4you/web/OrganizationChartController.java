package com.lego.care4you.web;

import com.lego.care4you.domain.OrganizationChart;
import com.lego.care4you.dto.OrganizationChartRequestDTO;
import com.lego.care4you.service.OrganizationChartService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/organizationCharts")
@Api(value = "organizationCharts", description = "Operations related to organizationCharts")
public class OrganizationChartController {

    private OrganizationChartService organizationChartService;

    public OrganizationChartController(OrganizationChartService organizationChartService) {
        this.organizationChartService = organizationChartService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<OrganizationChart> getSellers() {
        return organizationChartService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public OrganizationChart findById(@PathVariable String id) {
        return organizationChartService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public OrganizationChart addSeller(@RequestBody OrganizationChartRequestDTO dto) {
        return organizationChartService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public OrganizationChart deleteSeller(@PathVariable String id) {
        return organizationChartService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public OrganizationChart updateSeller(@PathVariable String id, @RequestBody OrganizationChartRequestDTO dto) {
        return organizationChartService.update(id, dto);
    }
}
