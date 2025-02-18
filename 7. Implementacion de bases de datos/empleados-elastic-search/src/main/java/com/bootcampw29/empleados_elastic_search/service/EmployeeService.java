package com.bootcampw29.empleados_elastic_search.service;

import com.bootcampw29.empleados_elastic_search.dto.EmployeeDTO;
import com.bootcampw29.empleados_elastic_search.dto.EmployeeRequestDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
    EmployeeDTO modifyEmployee(String id, EmployeeRequestDTO employeeRequestDTO);
}
