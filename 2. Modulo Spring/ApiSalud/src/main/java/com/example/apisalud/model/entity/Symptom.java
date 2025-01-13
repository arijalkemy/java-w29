package com.example.apisalud.model.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Symptom {
    private String code;
    private String name;
    private Integer severity;
}
