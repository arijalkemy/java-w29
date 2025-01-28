package com.example.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {
    private int id;

    private String nombre;
}
