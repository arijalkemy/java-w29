package com.bootcamp.CalculadoraCalorias.service;

import com.bootcamp.CalculadoraCalorias.dto.CaloriasPorPlatoDTO;
import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;
import com.bootcamp.CalculadoraCalorias.entity.Ingrediente;
import com.bootcamp.CalculadoraCalorias.entity.Plato;
import com.bootcamp.CalculadoraCalorias.repository.PlatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlatoServiceImpl implements PlatoService {

    private final PlatoRepository platoRepository;

    @Override
    public CaloriasPorPlatoDTO calcularCaloriasPorPlatoYPeso(String nombre, Double peso) {
        Plato plato = platoRepository.devolverPlatoPorNombre(nombre)
                .orElseThrow( ()-> new RuntimeException("Plato no encontrado"));

        Double caloriasPorPeso = calcularCaloriasPorPlatoYPeso(plato, peso);

        return new CaloriasPorPlatoDTO(nombre, caloriasPorPeso);
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientes(String nombre) {
        return platoRepository.devolverPlatoPorNombre(nombre).map(
                plato -> plato.getIngredientes().stream()
                        .map(ingrediente-> new IngredienteDTO(ingrediente.getNombre(), ingrediente.getCalorias()))
                        .toList())
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));
    }

    @Override
    public IngredienteDTO obtenerIngredienteConMasCalorias(String nombre) {
        Optional<Plato> plato = platoRepository.devolverPlatoPorNombre(nombre);
        if (plato.isPresent()) {
            Ingrediente ingrediente = plato.get().getIngredientes().stream().max(Comparator.comparing(Ingrediente::getCalorias))
                    .stream().findFirst().get();
            return new IngredienteDTO(ingrediente.getNombre(), ingrediente.getCalorias());
        } else {
            throw new RuntimeException("Plato no encontrado");
        }
    }

    private Double calcularCaloriasPorPlatoYPeso(Plato plato, Double peso) {
        return peso * plato.getIngredientes().stream().mapToInt(Ingrediente::getCalorias).sum();
    }

}
