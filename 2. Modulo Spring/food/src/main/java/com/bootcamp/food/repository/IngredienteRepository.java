package com.bootcamp.food.repository;

import com.bootcamp.food.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;

@Repository
public class IngredienteRepository {
    private final List<Ingrediente> ingredientes;
    public IngredienteRepository() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("food.json");
            if (inputStream == null) {
                throw new RuntimeException("Archivo food.json no encontrado");
            }
            ingredientes = objectMapper.readValue(inputStream, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo food.json", e);
        }
    }
    public List<Ingrediente> getIngredientes(){
        return this.ingredientes;
    }
    public Ingrediente getIngredienteByName(String name){
        return this.ingredientes.stream().filter( ingrediente -> ingrediente.getName().equals(name)).toList().getFirst();
    }
}
