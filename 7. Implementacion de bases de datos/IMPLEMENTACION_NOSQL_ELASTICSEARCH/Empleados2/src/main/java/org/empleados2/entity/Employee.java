package org.empleados2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document(indexName = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String lastName;
    private int age;
    private String city;
    private String state;



}
