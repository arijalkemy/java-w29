package com.example.employees.service;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.model.Employee;
import com.example.employees.repository.IEmployeeRepository;
import com.example.employees.util.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.save(EmployeeMapper.INSTANCE.employeeDTOToEmployee(employeeDTO));
        return EmployeeMapper.INSTANCE.employeeToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);

        return employees.stream()
                .map(EmployeeMapper.INSTANCE::employeeToEmployeeDTO)
                .toList();
    }

    @Override
    public EmployeeDTO findEmployeeById(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDTO(employee.get());
    }

    @Override
    public EmployeeDTO modifyEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.save(EmployeeMapper.INSTANCE.employeeDTOToEmployee(employeeDTO));
        return EmployeeMapper.INSTANCE.employeeToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO deleteEmployeeByID(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employeeRepository.deleteById(id);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDTO(employee.get());
    }
}
