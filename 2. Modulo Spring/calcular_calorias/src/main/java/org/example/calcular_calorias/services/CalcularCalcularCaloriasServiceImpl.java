package org.example.calcular_calorias.services;

import org.example.calcular_calorias.dtos.CaloriasTotalesDto;
import org.example.calcular_calorias.dtos.IngredientesDto;
import org.example.calcular_calorias.dtos.PlatosDto;
import org.example.calcular_calorias.entities.Platos;
import org.example.calcular_calorias.repositories.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalcularCalcularCaloriasServiceImpl implements ICalcularCaloriasService {
    @Autowired
    private IPlatoRepository platoRepository; // Repositorio para acceder a los datos de los platos

    @Override
    public CaloriasTotalesDto calcularCalorias(PlatosDto platosDto) {
        Platos plato = platoRepository.buscarPlatoPorNombre(platosDto.getNombre());
        if (plato != null) {
            Double totalCalorias = (plato.getCalorias() * platosDto.getPesoGramos()) / 100; // Suponiendo que tienes calorías por 100g
            List<IngredientesDto> ingredientes = obtenerIngredientes(plato.getNombre());
            return new CaloriasTotalesDto(totalCalorias, ingredientes);
        }
        return null; // O lanza una excepción si no se encuentra el plato
    }

    @Override
    public List<IngredientesDto> obtenerIngredientes(String nombrePlato) {
        Platos plato = platoRepository.buscarPlatoPorNombre(nombrePlato);
        if (plato != null) {
            return plato.getIngredientes().stream()
                    .map(ingrediente -> new IngredientesDto(ingrediente.getNombreIngrediente(), ingrediente.getCaloriasPorGramo()))
                    .collect(Collectors.toList()); // Convierte a DTO
        }
        return null; // Maneja el caso en que el plato no se encuentra
    }

    @Override
    public IngredientesDto obtenerIngredienteConMasCalorias(String nombrePlato) {
        List<IngredientesDto> ingredientes = obtenerIngredientes(nombrePlato);
        if (ingredientes != null) {
            return ingredientes.stream()
                    .max((ing1, ing2) -> Double.compare(ing1.getCalorias(), ing2.getCalorias()))
                    .orElse(null); // Devuelve el ingrediente con más calorías
        }
        return null; // Maneja caso si no hay ingredientes
    }
}
