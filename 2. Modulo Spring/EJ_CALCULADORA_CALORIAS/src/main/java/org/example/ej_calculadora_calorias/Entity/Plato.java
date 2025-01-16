package org.example.ej_calculadora_calorias.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;

    public Plato(String nombre, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    public Plato() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
