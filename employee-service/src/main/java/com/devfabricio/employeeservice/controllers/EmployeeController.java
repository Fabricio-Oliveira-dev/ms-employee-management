package com.devfabricio.employeeservice.controllers;

import com.devfabricio.employeeservice.dtos.EmployeeDTO;
import com.devfabricio.employeeservice.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // save Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // get employee
    @GetMapping(value = "{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable(value = "id") Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

}
