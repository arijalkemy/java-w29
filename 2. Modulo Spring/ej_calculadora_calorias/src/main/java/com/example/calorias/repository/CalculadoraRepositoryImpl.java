package com.example.calorias.repository;

import com.example.calorias.model.Comida;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Repository
public class CalculadoraRepositoryImpl implements CalculadoraRepository {

    private List<Comida> comidas;

    public CalculadoraRepositoryImpl() {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = CalculadoraRepositoryImpl.class.getResourceAsStream("/food.json");

        try {
            comidas = mapper.readValue(inputStream, new TypeReference<>() {});
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Comida> getAll() {
        return comidas;
    }

    @Override
    public Optional<Comida> getByName(String name) {
        return comidas.stream().filter(c -> c.getName().equalsIgnoreCase(name)).findFirst();
    }

}
