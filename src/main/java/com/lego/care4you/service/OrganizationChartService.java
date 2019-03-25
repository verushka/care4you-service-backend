package com.lego.care4you.service;

import com.lego.care4you.domain.OrganizationChart;
import com.lego.care4you.dto.OrganizationChartRequestDTO;
import com.lego.care4you.repository.OrganizationChartRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrganizationChartService extends GenericService<OrganizationChart, OrganizationChartRequestDTO> {

    private OrganizationChartRepository organizationChartRepository;

    public OrganizationChartService(OrganizationChartRepository organizationChartRepository) {
        this.organizationChartRepository = organizationChartRepository;
    }

    @Override
    public List<OrganizationChart> findAll() {
        return organizationChartRepository.findAll();
    }

    @Override
    public OrganizationChart findById(String id) {
        return organizationChartRepository.findOne(id);
    }

    @Override
    public OrganizationChart delete(String id) {
        OrganizationChart organizationChart = findById(id);
        organizationChartRepository.delete(organizationChart);

        return organizationChart;
    }

    @Override
    public OrganizationChart insert(OrganizationChartRequestDTO dto) {
        OrganizationChart organizationChart = buildCreateOrganizationChart(dto);
        organizationChartRepository.insert(organizationChart);
        return organizationChart;
    }

    @Override
    public OrganizationChart update(String id, OrganizationChartRequestDTO dto) {
        OrganizationChart organizationChart = findById(id);
        buildUpdateOrganizationChart(organizationChart, dto);
        organizationChartRepository.save(organizationChart);
        return organizationChart;
    }

    private OrganizationChart buildCreateOrganizationChart(OrganizationChartRequestDTO dto) {
        OrganizationChart organizationChart = new OrganizationChart();
        organizationChart.setTitle(dto.getTitle());
        organizationChart.setDescription(dto.getDescription());

        return organizationChart;
    }

    private void buildUpdateOrganizationChart(OrganizationChart organizationChart, OrganizationChartRequestDTO dto) {
        organizationChart.setTitle(dto.getTitle());
        organizationChart.setDescription(dto.getDescription());
    }
}
