package com.bootcampw29.empleados_elastic_search.repository;

import com.bootcampw29.empleados_elastic_search.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
