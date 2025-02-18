package com.bootcampw29.empleados_elastic_search.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employees")
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String department;
}
