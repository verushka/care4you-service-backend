package com.lego.care4you.service;

import com.lego.care4you.domain.Incident;
import com.lego.care4you.dto.IncidentRequestDTO;
import com.lego.care4you.repository.EmployeeRepository;
import com.lego.care4you.repository.IncidentRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IncidentService extends GenericService<Incident, IncidentRequestDTO> {

    private IncidentRepository incidentRepository;

    private EmployeeRepository employeeRepository;

    public IncidentService(IncidentRepository incidentRepository, EmployeeRepository employeeRepository) {
        this.incidentRepository = incidentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }

    @Override
    public Incident findById(String id) {
        return incidentRepository.findOne(id);
    }

    @Override
    public Incident delete(String id) {
        Incident incident = findById(id);
        incidentRepository.delete(incident);
        return incident;
    }

    @Override
    public Incident insert(IncidentRequestDTO dto) {
        Incident incident = buildCreateIncident(dto);
        incident = incidentRepository.insert(incident);
        return incident;
    }

    @Override
    public Incident update(String id, IncidentRequestDTO dto) {
        Incident incident = findById(id);
        buildUpdateIncident(incident, dto);
        incident = incidentRepository.save(incident);
        return incident;
    }

    private Incident buildCreateIncident(IncidentRequestDTO dto) {
        Incident incident = new Incident();
        setIncidentInformation(dto, incident);

        return incident;
    }

    private void buildUpdateIncident(Incident incident, IncidentRequestDTO dto) {
        setIncidentInformation(dto, incident);
    }

    private void setIncidentInformation(IncidentRequestDTO dto, Incident incident) {
        incident.setName(dto.getName());
        incident.setDate(dto.getDate());
        incident.setDescription(dto.getDescription());
        incident.setType(dto.getType());
        incident.setSeverity(dto.getSeverity());

        incident.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
    }
}
