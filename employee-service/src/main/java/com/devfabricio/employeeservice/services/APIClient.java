package com.devfabricio.employeeservice.services;

import com.devfabricio.employeeservice.dtos.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", name = "DEPARTMENT-SERVICE")
public interface APIClient {
    // get department
    @GetMapping("api/department/{department-code}")
    DepartmentDTO getDepartment(@PathVariable(value = "department-code") String departmentCode);
}
