package com.lego.care4you.service;

import com.lego.care4you.domain.Responsible;
import com.lego.care4you.dto.ResponsibleRequestDTO;
import com.lego.care4you.repository.*;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResponsibleService extends GenericService<Responsible, ResponsibleRequestDTO> {

    private ResponsibleRepository responsibleRepository;

    private EmployeeRepository employeeRepository;

    private SafetyEquipmentRepository safetyEquipmentRepository;

    public ResponsibleService(ResponsibleRepository responsibleRepository, EmployeeRepository employeeRepository, SafetyEquipmentRepository safetyEquipmentRepository) {
        this.responsibleRepository = responsibleRepository;
        this.employeeRepository = employeeRepository;
        this.safetyEquipmentRepository = safetyEquipmentRepository;
    }

    @Override
    public List<Responsible> findAll() {
        return responsibleRepository.findAll();
    }

    @Override
    public Responsible findById(String id) {
        return responsibleRepository.findOne(id);
    }

    @Override
    public Responsible delete(String id) {
        Responsible Responsible = responsibleRepository.findOne(id);

        responsibleRepository.delete(Responsible);

        return Responsible;
    }

    @Override
    public Responsible insert(ResponsibleRequestDTO dto) {
        Responsible Responsible = buildCreateResponsible(dto);

        responsibleRepository.insert(Responsible);

        return Responsible;
    }

    @Override
    public Responsible update(String id, ResponsibleRequestDTO dto) {
        Responsible Responsible = findById(id);

        buildUpdateResponsible(Responsible, dto);
        responsibleRepository.save(Responsible);

        return Responsible;
    }

    private Responsible buildCreateResponsible(ResponsibleRequestDTO dto) {
        Responsible responsible = new Responsible();

        responsible.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
        responsible.setSafetyEquipment(safetyEquipmentRepository.findOne(dto.getSafetyEquipmentId()));

        return responsible;
    }

    private void buildUpdateResponsible(Responsible responsible, ResponsibleRequestDTO dto) {
        responsible.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
        responsible.setSafetyEquipment(safetyEquipmentRepository.findOne(dto.getSafetyEquipmentId()));
    }
}
