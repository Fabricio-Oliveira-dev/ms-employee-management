package com.devfabricio.departmentservice.controllers;

import com.devfabricio.departmentservice.dtos.DepartmentDTO;
import com.devfabricio.departmentservice.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // save department
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // get department
    @GetMapping(value = "{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable(value = "department-code") String departmentCode) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }
}
