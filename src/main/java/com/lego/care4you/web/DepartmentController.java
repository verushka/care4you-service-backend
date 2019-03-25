package com.lego.care4you.web;

import com.lego.care4you.domain.Department;
import com.lego.care4you.dto.DepartmentRequestDTO;
import com.lego.care4you.service.DepartmentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departments")
@Api(value = "departments", description = "Operations related to departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Department findById(@PathVariable String id) {
        return departmentService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Department insert(@RequestBody DepartmentRequestDTO dto) {
        return departmentService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Department delete(@PathVariable String id) {
        return departmentService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Department update(@PathVariable String id, @RequestBody DepartmentRequestDTO dto) {
        return departmentService.update(id, dto);
    }
}
