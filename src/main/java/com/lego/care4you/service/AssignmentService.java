package com.lego.care4you.service;

import com.lego.care4you.domain.Assignment;
import com.lego.care4you.dto.AssignmentRequestDTO;
import com.lego.care4you.repository.*;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AssignmentService extends GenericService<Assignment, AssignmentRequestDTO> {

    private AssignmentRepository assignmentRepository;

    private DepartmentRepository departmentRepository;

    private PositionRepository positionRepository;

    private OrganizationChartRepository organizationChartRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, DepartmentRepository departmentRepository, PositionRepository positionRepository, OrganizationChartRepository organizationChartRepository) {
        this.assignmentRepository = assignmentRepository;
        this.departmentRepository = departmentRepository;
        this.positionRepository = positionRepository;
        this.organizationChartRepository = organizationChartRepository;
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment findById(String id) {
        return assignmentRepository.findOne(id);
    }

    @Override
    public Assignment delete(String id) {
        Assignment assignment = findById(id);
        assignmentRepository.delete(assignment);
        return assignment;
    }

    @Override
    public Assignment insert(AssignmentRequestDTO dto) {
        Assignment assignment = buildCreateAssignment(dto);
        assignment = assignmentRepository.insert(assignment);
        return assignment;
    }

    @Override
    public Assignment update(String id, AssignmentRequestDTO dto) {
        Assignment assignment = findById(id);
        buildUpdateAssignment(assignment, dto);
        assignment = assignmentRepository.save(assignment);
        return assignment;
    }

    private Assignment buildCreateAssignment(AssignmentRequestDTO dto) {
        Assignment assignment = new Assignment();
        setAssignmentInformation(dto, assignment);

        return assignment;
    }

    private void buildUpdateAssignment(Assignment assignment, AssignmentRequestDTO dto) {
        setAssignmentInformation(dto, assignment);
    }

    private void setAssignmentInformation(AssignmentRequestDTO dto, Assignment assignment) {
        assignment.setOrganizationChart(organizationChartRepository.findOne(dto.getOrganizationChartId()));
        assignment.setDepartment(departmentRepository.findOne(dto.getDepartmentId()));
        assignment.setPosition(positionRepository.findOne(dto.getPositionId()));
    }
}
