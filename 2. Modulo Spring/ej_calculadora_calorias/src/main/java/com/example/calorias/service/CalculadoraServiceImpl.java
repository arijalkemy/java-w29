package com.example.calorias.service;

import com.example.calorias.model.Comida;
import com.example.calorias.repository.CalculadoraRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalculadoraServiceImpl implements CalculadoraService {

    private final CalculadoraRepositoryImpl repo;

    @Override
    public Integer getCalorias(String plato) {
        Optional<Comida> optionalComida = repo.getByName(plato);

        if (optionalComida.isEmpty()) {
            throw new IllegalArgumentException("No se encontró el plato");
        }

        return optionalComida.get().getCalories();
    }

    @Override
    public List<String> getIngredientes(String plato) {
        return null;
    }

}
