package com.tmicroservice.department_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private Integer id;
    private String epfNo;
    private Integer departmentId;
    private String name;
    private String position;

    public Employee() {
    }

    public Employee(Integer id, String epfNo, Integer departmentId, String name, String position) {
        this.id = id;
        this.epfNo = epfNo;
        this.departmentId = departmentId;
        this.name = name;
        this.position = position;
    }
}
