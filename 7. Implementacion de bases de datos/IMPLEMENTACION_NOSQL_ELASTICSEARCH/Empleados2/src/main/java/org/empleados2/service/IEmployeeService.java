package org.empleados2.service;

import org.empleados2.dto.EmployeeDTO;
import org.empleados2.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee saveEmployee(EmployeeDTO employee);
    List<Employee> getAllEmployees();
    EmployeeDTO updateEmployee(String id, EmployeeDTO employee);
}
