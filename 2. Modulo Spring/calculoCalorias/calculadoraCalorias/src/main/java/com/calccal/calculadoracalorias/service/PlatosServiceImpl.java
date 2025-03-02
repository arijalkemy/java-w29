package com.calccal.calculadoracalorias.service;

import com.calccal.calculadoracalorias.dto.IngredienteDTO;
import com.calccal.calculadoracalorias.dto.PlatoDTO;
import com.calccal.calculadoracalorias.model.Ingrediente;
import com.calccal.calculadoracalorias.model.Plato;
import com.calccal.calculadoracalorias.repository.IPlatosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatosServiceImpl implements IPlatosService{

    IPlatosRepository iPlatosRepository;

    public PlatosServiceImpl(IPlatosRepository iPlatosRepository){
        this.iPlatosRepository = iPlatosRepository;
    }

    @Override
    public List<IngredienteDTO> findAllIngr() {
        ObjectMapper mp = new ObjectMapper();
        List<Ingrediente> ingredientes = iPlatosRepository.findAllIngr();
        return ingredientes.stream()
                .map(ingrediente -> mp.convertValue(ingrediente,IngredienteDTO.class))
                .toList();
    }

    @Override
    public List<PlatoDTO> findAllPlatos() {
        ObjectMapper mp = new ObjectMapper();
        List<Plato> platos = iPlatosRepository.findAllPlatos();
        return platos.stream()
                .map(plato -> mp.convertValue(plato,PlatoDTO.class))
                .toList();
    }

    @Override
    public String findCaloriasPorPlato(String nombrePlato) {
        ObjectMapper mp = new ObjectMapper();
        Plato plato = iPlatosRepository.findPlatoByName(nombrePlato);
        PlatoDTO platoDTO = mp.convertValue(plato, PlatoDTO.class);
        return "Las calorías totales de " + nombrePlato + " son: " + platoDTO.getCalories();
    }

    @Override
    public List<IngredienteDTO> findInfoPorPlato(String nombrePlato) {
        ObjectMapper mp = new ObjectMapper();
        Plato plato = iPlatosRepository.findPlatoByName(nombrePlato);
        PlatoDTO platoDTO = mp.convertValue(plato, PlatoDTO.class);
        return platoDTO.getIngredientes();
    }

    @Override
    public IngredienteDTO findIngredienteConMasCalorias(String nombrePlato) {
        ObjectMapper mp = new ObjectMapper();
        Plato plato = iPlatosRepository.findPlatoByName(nombrePlato);

        PlatoDTO platoDTO = mp.convertValue(plato, PlatoDTO.class);

        IngredienteDTO ingredienteConMasCalorias = platoDTO.getIngredientes().stream()
                .max((i1, i2) -> Integer.compare(i1.getCalories(), i2.getCalories()))
                .orElse(null);

        return ingredienteConMasCalorias;
    }

}
