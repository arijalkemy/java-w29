package com.bootcampw29.empleados_elastic_search.controller;

import com.bootcampw29.empleados_elastic_search.dto.EmployeeDTO;
import com.bootcampw29.empleados_elastic_search.dto.EmployeeRequestDTO;
import com.bootcampw29.empleados_elastic_search.model.Employee;
import com.bootcampw29.empleados_elastic_search.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> postEmployee(
            @Valid @RequestBody EmployeeRequestDTO employeeRequestDTO
    ) {
        return new ResponseEntity<>(this.employeeService.createEmployee(employeeRequestDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> putEmployee(
            @PathVariable String id,
            @Valid @RequestBody EmployeeRequestDTO employeeRequestDTO
    ) {
        return new ResponseEntity<>(this.employeeService.modifyEmployee(id, employeeRequestDTO), HttpStatus.OK);
    }

}
