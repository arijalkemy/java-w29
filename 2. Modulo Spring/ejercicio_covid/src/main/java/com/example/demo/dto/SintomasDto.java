package com.example.demo.dto;

public class SintomasDto {
    private Integer codigo;
    private String nombre;
    private Integer nivel_de_gravedad;

    public SintomasDto() {
    }

    public SintomasDto(Integer codigo, String nombre, Integer nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(Integer nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    @Override
    public String toString() {
        return "SintomasDto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", nivel_de_gravedad=" + nivel_de_gravedad +
                '}';
    }
}
