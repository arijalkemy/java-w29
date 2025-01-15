package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;
}
