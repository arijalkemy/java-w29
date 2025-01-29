package com.example.EjercicioCovidBootcamp.Entity;

public class Sintoma {
    private Integer codigo;
    private String nombre;
    private String nivel_de_gravedad;

    public Sintoma(Integer codigo, String nombre, String nivel_de_gravedad) {
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

    public String getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(String nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", nivel_de_gravedad='" + nivel_de_gravedad + '\'' +
                '}';
    }
}
