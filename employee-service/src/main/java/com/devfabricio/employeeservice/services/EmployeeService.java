package com.devfabricio.employeeservice.services;

import com.devfabricio.employeeservice.dtos.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);
}
