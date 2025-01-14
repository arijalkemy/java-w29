package com.example.deportistas.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Deporte {
    private String nombre;
    private String nivel;
}
