package com.bootcamp.service;

import com.bootcamp.dao.IPlatoRepository;
import com.bootcamp.dto.response.IngredienteDto;
import com.bootcamp.model.Ingrediente;
import com.bootcamp.model.Plato;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PlatoService implements IPlatoService{

    private final IPlatoRepository platoRepository;

    public PlatoService(IPlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public Double getCantidadTotalCaloriasPlato(String nombre) {
        return calcularCantidadCalorias(getPlatoByNombre(nombre));
    }

    private Double calcularCantidadCalorias(Plato plato){
        return plato.getIngredientes().stream()
                .mapToDouble(i -> i.getCalorias() * i.getUnidad())
                .sum();
    }

    @Override
    public List<IngredienteDto> getListaIngredientesYCalorias(String nombre) {
        ObjectMapper mapper = new ObjectMapper();
        return getPlatoByNombre(nombre).getIngredientes().stream()
                .map(i -> mapper.convertValue(i , IngredienteDto.class))
                .toList();
    }

    @Override
    public IngredienteDto getIngredienteMayorCalorias(String nombre) {
        return getPlatoByNombre(nombre).getIngredientes().stream()
                .max(Comparator.comparingDouble(Ingrediente::getCalorias))
                .map(ingrediente -> {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.convertValue(ingrediente, IngredienteDto.class);
                })
                .orElseThrow(() -> new RuntimeException("No hay ingredientes en el plato"));

    }

    private Plato getPlatoByNombre(String nombre){
        Optional<Plato> plato = platoRepository.getPlatoByNombre(nombre);
        if (plato.isEmpty()){
            throw new RuntimeException("Plato no encontrado");
        }
        return plato.get();
    }
}
