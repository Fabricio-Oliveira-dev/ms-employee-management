package com.devfabricio.departmentservice.services;

import com.devfabricio.departmentservice.dtos.DepartmentDTO;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentByCode(String code);

}
