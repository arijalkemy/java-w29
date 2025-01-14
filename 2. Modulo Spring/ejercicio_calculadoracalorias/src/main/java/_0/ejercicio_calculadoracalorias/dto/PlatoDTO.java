package _0.ejercicio_calculadoracalorias.dto;

import _0.ejercicio_calculadoracalorias.model.Ingredientes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PlatoDTO {
    private String nombre;
    private Double peso;

    private  Integer caloriasPlato;
    @JsonProperty("ingredientes")
    private List<Ingredientes> listIngredientes = new ArrayList<>();
    private Ingredientes ingredienteCalorico;

    public PlatoDTO(List<Ingredientes> listIngredientes) {
        this.listIngredientes = listIngredientes;
        this.caloriasPlato = 0;
        this.ingredienteCalorico= new Ingredientes();

    }

    public PlatoDTO() {
    }

    //getter y stter

    public Integer getCaloriasPlato() {
        return caloriasPlato;
    }

    public void setCaloriasPlato(Integer caloriasPlato) {
        this.caloriasPlato = caloriasPlato;
    }

    public List<Ingredientes> getListIngredientes() {
        return listIngredientes;
    }

    public void setListIngredientes(List<Ingredientes> listIngredientes) {
        this.listIngredientes = listIngredientes;
    }

    public Ingredientes getIngredienteCalorico() {
        return ingredienteCalorico;
    }

    public void setIngredienteCalorico(Ingredientes ingredienteCalorico) {
        this.ingredienteCalorico = ingredienteCalorico;
    }

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

    @Override
    public String toString() {
        return "PlatoDTO{" +
                "caloriasPlato=" + caloriasPlato +
                ", listIngredientes=" + listIngredientes +
                ", ingredienteCalorico=" + ingredienteCalorico +
                '}';
    }
}
