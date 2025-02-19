package exercise.elasticsearch_empleados.repository;

import exercise.elasticsearch_empleados.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, Long> {
}
