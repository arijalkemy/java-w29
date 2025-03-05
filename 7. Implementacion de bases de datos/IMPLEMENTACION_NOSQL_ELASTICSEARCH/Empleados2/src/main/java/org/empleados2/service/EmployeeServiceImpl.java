package org.empleados2.service;

import org.empleados2.dto.EmployeeDTO;
import org.empleados2.entity.Employee;
import org.empleados2.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(EmployeeDTO employee) {
        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setLastName(employee.getLastName());
        employee1.setAge(employee.getAge());
        employee1.setCity(employee.getCity());
        employee1.setState(employee.getState());

        return employeeRepository.save(employee1);
    }


    public EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(employee.getName());
            employee.setLastName(employee.getLastName());
            employee.setAge(employee.getAge());
            employee.setCity(employee.getCity());
            employee.setState(employee.getState());
            Employee updatedEmployee = employeeRepository.save(employee);
            employeeDTO.setId(updatedEmployee.getId());
            return employeeDTO;
        }
        return null;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }


}
