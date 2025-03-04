package com.example.employees.controller;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.modifyEmployee(employeeDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.deleteEmployeeByID(id));
    }
}
