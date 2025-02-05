package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    private String name;
    private Double score;

    public SubjectDTO(String name, Double score) {
        this.name = name;
        this.score = score;
    }
}