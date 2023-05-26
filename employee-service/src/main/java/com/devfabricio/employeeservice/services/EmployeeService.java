package com.devfabricio.employeeservice.services;

import com.devfabricio.employeeservice.dtos.APIResponseDTO;
import com.devfabricio.employeeservice.dtos.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDto);

    APIResponseDTO getEmployeeById(Long employeeId);
}
