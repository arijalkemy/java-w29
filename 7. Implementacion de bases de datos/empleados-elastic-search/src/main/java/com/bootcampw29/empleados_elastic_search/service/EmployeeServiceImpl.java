package com.bootcampw29.empleados_elastic_search.service;

import com.bootcampw29.empleados_elastic_search.dto.EmployeeDTO;
import com.bootcampw29.empleados_elastic_search.dto.EmployeeRequestDTO;
import com.bootcampw29.empleados_elastic_search.model.Employee;
import com.bootcampw29.empleados_elastic_search.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = modelMapper.map(employeeRequestDTO, Employee.class);
        Employee savedEmployee = this.employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO modifyEmployee(String id, EmployeeRequestDTO employeeRequestDTO) {
        //TODO: Implement existing data validation
        Employee employee = modelMapper.map(employeeRequestDTO, Employee.class);
        employee.setId(id);
        Employee updatedEmployee = this.employeeRepository.save(employee);
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
    }
}
