package com.lego.care4you.web;

import com.lego.care4you.domain.Employee;
import com.lego.care4you.dto.EmployeeRequestDTO;
import com.lego.care4you.service.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
@Api(value = "employees", description = "Operations related to employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Employee findById(@PathVariable String id) {
        return employeeService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee insert(@RequestBody EmployeeRequestDTO dto) {
        return employeeService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Employee delete(@PathVariable String id) {
        return employeeService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Employee update(@PathVariable String id, @RequestBody EmployeeRequestDTO dto) {
        return employeeService.update(id, dto);
    }
}
