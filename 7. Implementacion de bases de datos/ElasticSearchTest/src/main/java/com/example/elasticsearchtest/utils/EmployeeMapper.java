package com.example.elasticsearchtest.utils;

import com.example.elasticsearchtest.entity.Employee;
import com.example.elasticsearchtest.entity.dto.EmployeeDTO;

public class EmployeeMapper {
    public static EmployeeDTO toEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .nombre(employee.getNombre())
                .apellido(employee.getApellido())
                .edad(employee.getEdad())
                .ciudad(employee.getCiudad())
                .provincia(employee.getProvincia())
                .build();
    }

    public static Employee toEmployee(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .nombre(employeeDTO.getNombre())
                .apellido(employeeDTO.getApellido())
                .edad(employeeDTO.getEdad())
                .ciudad(employeeDTO.getCiudad())
                .provincia(employeeDTO.getProvincia())
                .build();
    }
}
