package com.org.meli.caloriecalculator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.meli.caloriecalculator.dto.IngredienteDto;
import com.org.meli.caloriecalculator.dto.PlatoDto;
import com.org.meli.caloriecalculator.entity.Ingrediente;
import com.org.meli.caloriecalculator.entity.Plato;
import com.org.meli.caloriecalculator.exception.NotFoundException;
import com.org.meli.caloriecalculator.repository.IPlatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImpl implements IPlatoService {
    private final IPlatoRepository platoRepository;

    public PlatoServiceImpl(IPlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public String caloriasTotalesPlatos(String nombrePlato, Integer cantidad) {
        Plato platoEncontrado= platoRepository.buscarPlatoPorNombre(nombrePlato);
        if(platoEncontrado==null){
            throw new NotFoundException("El plato " + nombrePlato + " no existe");
        }
        return "Un plato de " + platoEncontrado.getNombre() + " tiene: " + platoEncontrado.getCalorias()  + " calorias" +
                "\nlas calorias por " + cantidad + " platos son: " + platoEncontrado.getCalorias() * cantidad ;
    }

    @Override
    public PlatoDto mostrarIngredientesdePlato(String nombrePlato) {
        Plato platoEncontrado= platoRepository.buscarPlatoPorNombre(nombrePlato);
        if(platoEncontrado==null){
            throw new NotFoundException("El plato " + nombrePlato + " no existe");
        }
        ObjectMapper mapper = new ObjectMapper();
        List<IngredienteDto> ingredienteDtosList= mapper.convertValue(platoEncontrado.getIngredientes(), List.class);
        return new PlatoDto(ingredienteDtosList);
    }

    @Override
    public IngredienteDto buscarIngredienteConMasCalorias(String nombrePlato) {
        Ingrediente ingrediente = platoRepository.buscarIngredienteConMasCalorias(nombrePlato);
        if (ingrediente == null) {
            throw new NotFoundException("El plato " + nombrePlato + " no existe");
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(ingrediente, IngredienteDto.class);
    }
}
