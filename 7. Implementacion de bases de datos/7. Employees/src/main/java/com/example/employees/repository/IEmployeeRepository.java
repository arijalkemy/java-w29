package com.example.employees.repository;

import com.example.employees.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
