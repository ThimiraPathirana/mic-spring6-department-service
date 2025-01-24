package com.tmicroservice.department_service.repository;

import com.tmicroservice.department_service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    List<Department> departments = new ArrayList<>();

    public Department saveDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department getDepartmentById(Integer departmentId) {
        Department filterVal = departments.stream()
                .filter(department -> department.getId().equals(departmentId))
                .findFirst()
                .orElseThrow();
        return filterVal;
    }

    public List<Department> findAll() {
        return departments;
    }
}
