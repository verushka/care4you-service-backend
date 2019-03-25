package com.lego.care4you.service;

import com.lego.care4you.domain.Employee;
import com.lego.care4you.dto.EmployeeRequestDTO;
import com.lego.care4you.repository.EmployeeRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService extends GenericService<Employee, EmployeeRequestDTO> {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee delete(String id) {
        Employee employee = findById(id);

        employeeRepository.delete(employee);

        return employee;
    }

    @Override
    public Employee insert(EmployeeRequestDTO dto) {
        Employee employee = buildCreateEmployee(dto);

        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee update(String id, EmployeeRequestDTO dto) {
        Employee employee = findById(id);

        buildUpdateEmployee(employee, dto);
        employeeRepository.save(employee);

        return employee;
    }

    private Employee buildCreateEmployee(EmployeeRequestDTO dto) {
        Employee employee = new Employee();

        setEmployeeInformation(dto, employee);

        return employee;
    }

    private void buildUpdateEmployee(Employee employee, EmployeeRequestDTO dto) {

        setEmployeeInformation(dto, employee);
    }

    private static void setEmployeeInformation(EmployeeRequestDTO dto, Employee employee) {
        employee.setCI(dto.getCI());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAddress(dto.getAddress());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
    }
}
