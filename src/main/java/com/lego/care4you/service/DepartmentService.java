package com.lego.care4you.service;

import com.lego.care4you.domain.Company;
import com.lego.care4you.domain.Department;
import com.lego.care4you.dto.DepartmentRequestDTO;
import com.lego.care4you.repository.CompanyRepository;
import com.lego.care4you.repository.DepartmentRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService extends GenericService<Department, DepartmentRequestDTO> {

    private DepartmentRepository departmentRepository;

    private CompanyRepository companyRepository;

    public DepartmentService(DepartmentRepository departmentRepository, CompanyRepository companyRepository) {
        this.departmentRepository = departmentRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(String id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public Department delete(String id) {
        Department department = findById(id);
        departmentRepository.delete(department);
        return department;
    }

    @Override
    public Department insert(DepartmentRequestDTO dto) {
        Department department = buildCreateDepartment(dto);
        department = departmentRepository.insert(department);
        return department;
    }

    @Override
    public Department update(String id, DepartmentRequestDTO dto) {
        Department department = findById(id);
        buildUpdateDepartment(department, dto);
        department = departmentRepository.save(department);
        return department;
    }

    private Department buildCreateDepartment(DepartmentRequestDTO dto) {
        Department department = new Department();
        setDepartmentInformation(dto, department);

        return department;
    }

    private void buildUpdateDepartment(Department department, DepartmentRequestDTO dto) {
        setDepartmentInformation(dto, department);
    }

    private void setDepartmentInformation(DepartmentRequestDTO dto, Department department) {
        department.setName(dto.getName());
        department.setCode(dto.getCode());
        department.setDescription(dto.getDescription());
        department.setCompany(companyRepository.findOne(dto.getCompanyId()));
    }
}
