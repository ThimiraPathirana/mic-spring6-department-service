package com.tmicroservice.department_service.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Department {

    private Integer id;
    private String departmentName;
    private List<Employee> employeeList;

    public Department() {
    }

    public Department(Integer id, String departmentName, List<Employee> employeeList) {
        this.id = id;
        this.departmentName = departmentName;
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
