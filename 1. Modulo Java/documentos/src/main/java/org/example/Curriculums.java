package org.example;
import java.util.List;

public class Curriculums implements Documento {
    private String nombre;
    private int edad;
    private String genero;
    private List<String> habilidades;

    public Curriculums(String nombre, int edad, String genero, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Genero: " + genero);
        System.out.println("Habilidades:");
        for (String habilidad : habilidades) {
            System.out.println("- " + habilidad);
        }
    }
}
