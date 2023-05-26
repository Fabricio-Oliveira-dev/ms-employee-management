package com.devfabricio.employeeservice.services.impl;

import com.devfabricio.employeeservice.dtos.APIResponseDTO;
import com.devfabricio.employeeservice.dtos.DepartmentDTO;
import com.devfabricio.employeeservice.dtos.EmployeeDTO;
import com.devfabricio.employeeservice.entities.Employee;
import com.devfabricio.employeeservice.repositories.EmployeeRepository;
import com.devfabricio.employeeservice.services.APIClient;
import com.devfabricio.employeeservice.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;
    // private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDto) {

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO savedEmployeeDto = new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDTO getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDTO departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDTO employeeDto = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDTO apiResponseDto = new APIResponseDTO();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}