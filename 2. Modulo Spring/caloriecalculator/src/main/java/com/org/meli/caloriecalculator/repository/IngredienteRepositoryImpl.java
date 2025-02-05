package com.org.meli.caloriecalculator.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.meli.caloriecalculator.entity.Ingrediente;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository {
    private List<Ingrediente> listaDeIngredientes = new ArrayList<>();

    public IngredienteRepositoryImpl() {
        try {
            loadDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDataBase() throws IOException {
        File file = ResourceUtils.getFile("classpath:static/ingredientes.json");
        ObjectMapper objectMapper = new ObjectMapper();
        listaDeIngredientes = objectMapper.readValue(file, new TypeReference<List<Ingrediente>>() {});
    }

    @Override
    public List<Ingrediente> obtenerIngredientes() {
        return listaDeIngredientes;
    }

    @Override
    public Ingrediente buscarIngredienteConMasCalorias() {
        return listaDeIngredientes.stream()
                .max(Comparator.comparing(Ingrediente::getCalorias)).orElse(null);
    }
}