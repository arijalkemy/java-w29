package com.example.elasticsearchtest.service;

import com.example.elasticsearchtest.entity.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {
    void saveEmployee(EmployeeDTO employeeDTO);
    void updateEmployee(EmployeeDTO employeeDTO, String id);
    void deleteEmployee(String id);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(String id);
}
