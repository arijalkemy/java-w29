package com.bootcampw29.empleados_elastic_search.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @Min(0)
    private Integer age;
    @NotNull
    @NotBlank
    private String city;
    @NotNull
    @NotBlank
    private String department;

}
