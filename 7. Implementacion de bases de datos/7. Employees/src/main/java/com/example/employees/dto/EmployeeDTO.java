package com.example.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String id;
    private String name;
    private String lastname;
    private Integer age;
    private String city;
    private String province;
}
