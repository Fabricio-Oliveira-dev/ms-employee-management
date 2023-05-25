package com.devfabricio.employeeservice.services.impl;

import com.devfabricio.employeeservice.dtos.APIResponseDTO;
import com.devfabricio.employeeservice.dtos.DepartmentDTO;
import com.devfabricio.employeeservice.dtos.EmployeeDTO;
import com.devfabricio.employeeservice.entities.Employee;
import com.devfabricio.employeeservice.repositories.EmployeeRepository;
import com.devfabricio.employeeservice.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;
    private WebClient webClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO savedEmployeeDTO = new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDTO;
    }

    @Override
    public APIResponseDTO getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

        /*ResponseEntity<DepartmentDTO> responseEntity =  restTemplate
                .getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode(),
                DepartmentDTO.class);

        DepartmentDTO departmentDTO = responseEntity.getBody();*/

        DepartmentDTO departmentDTO = webClient.get().uri("http://localhost:8080/api/department/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();

        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployee(employeeDTO);
        apiResponseDTO.setDepartment(departmentDTO);

        return apiResponseDTO;
    }
}
