package dev.calories.entity;

public class Ingrediente {

    private String nombre;
    private Double calorias;
    private Integer unidad;

    public Ingrediente(String nombre, Double calorias, Integer unidad) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.unidad = unidad;
    }

    public Ingrediente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }

}
