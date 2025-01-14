package org.example.ejercicios_practicos_2_vivo.dto;

import java.util.List;

public class PlatoResponseDto {
    private String nombre;
    private List<String> ingredientes;
    private String ingredienteMayorCalorias;
    private int caloriasTotal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getIngredienteMayorCalorias() {
        return ingredienteMayorCalorias;
    }

    public void setIngredienteMayorCalorias(String ingredienteMayorCalorias) {
        this.ingredienteMayorCalorias = ingredienteMayorCalorias;
    }

    public int getCaloriasTotal() {
        return caloriasTotal;
    }

    public void setCaloriasTotal(int caloriasTotal) {
        this.caloriasTotal = caloriasTotal;
    }
}
