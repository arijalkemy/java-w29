package com.example.elasticsearchtest.service;

import com.example.elasticsearchtest.entity.Employee;
import com.example.elasticsearchtest.entity.dto.EmployeeDTO;
import com.example.elasticsearchtest.repository.IEmployeeRepository;
import com.example.elasticsearchtest.utils.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEmployee(employeeDTO);
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO, String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee = EmployeeMapper.toEmployee(employeeDTO);
        employee.setId(id);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();

        return employees.stream().map(EmployeeMapper::toEmployeeDTO).toList();
    }


    @Override
    public EmployeeDTO getEmployeeById(String id) {
        return EmployeeMapper.toEmployeeDTO(employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found")));
    }
}
