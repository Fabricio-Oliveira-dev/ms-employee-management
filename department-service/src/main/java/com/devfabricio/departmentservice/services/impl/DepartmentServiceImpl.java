package com.devfabricio.departmentservice.services.impl;

import com.devfabricio.departmentservice.dtos.DepartmentDTO;
import com.devfabricio.departmentservice.entities.Department;
import com.devfabricio.departmentservice.repositories.DepartmentRepository;
import com.devfabricio.departmentservice.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        // convert departmentDTO into department jpa entity
        Department department = new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode()
        );

        Department savedDepartment = departmentRepository.save(department);

        // convert department jpa entity into departmentDTO
        DepartmentDTO savedDepartmentDTO = new DepartmentDTO(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );

        return savedDepartmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDTO departmentDTO = new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

        return departmentDTO;
    }
}
