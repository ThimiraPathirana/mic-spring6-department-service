package com.tmicroservice.department_service.client;

import com.tmicroservice.department_service.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

/**
 * This class is a declarative client in reactive programing
 */
@HttpExchange
public interface EmployeeClient {

    @GetExchange("employee/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Integer id);
}
