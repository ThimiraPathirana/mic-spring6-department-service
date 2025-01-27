package com.tmicroservice.department_service.controller;

import com.tmicroservice.department_service.client.EmployeeClient;
import com.tmicroservice.department_service.model.Department;
import com.tmicroservice.department_service.model.Employee;
import com.tmicroservice.department_service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeClient employeeClient;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentRepository.saveDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Integer id) {
        return departmentRepository.getDepartmentById(id);
    }

    @GetMapping("/with-department")
    public List<Department> findAllWithDepartment() {
        List<Department> departmentList = departmentRepository.findAll();
        departmentList.forEach(
                department ->
                        department.setEmployeeList(employeeClient.findByDepartmentId(department.getId())));
        return departmentList;
    }

}
