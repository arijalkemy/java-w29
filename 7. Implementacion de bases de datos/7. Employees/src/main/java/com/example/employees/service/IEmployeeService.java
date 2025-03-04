package com.example.employees.service;

import com.example.employees.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> findAllEmployees();
    EmployeeDTO findEmployeeById(String id);
    EmployeeDTO modifyEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO deleteEmployeeByID(String id);
}
