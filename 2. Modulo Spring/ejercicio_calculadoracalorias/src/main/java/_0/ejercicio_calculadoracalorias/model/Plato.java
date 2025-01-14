package _0.ejercicio_calculadoracalorias.model;

import java.util.ArrayList;
import java.util.List;

public class Plato {
    private String nombre;
    private Double peso;
    private List<Ingredientes> ingredientes;

    //contructor


    public Plato(String nombre, Double peso) {
        this.nombre = nombre;
        this.peso = peso;
        this.ingredientes = new ArrayList<>();
    }

    //setters y getters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    // to string


    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
