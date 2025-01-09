package org.bootcamp;

import java.util.List;

public class Curriculum extends Documento{

    private String nombre;
    private String apellido;
    private Integer edad;
    private List<String> habilidades;

    @Override
    public void imprimir() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}';
    }
}
