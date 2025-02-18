package com.bootcampw29.empleados_elastic_search.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String department;
}
