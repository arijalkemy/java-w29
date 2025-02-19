package exercise.elasticsearch_empleados.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleados")
public class Employee {

    @Id
    private Long id;

    private String name;
    private String lastName;
    private Integer age;
}
