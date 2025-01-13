package com.example.apisalud.model.entity;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class Person {
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private List<Symptom> symptoms;
}
