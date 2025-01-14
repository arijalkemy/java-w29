package _0.ejercicio_calculadoracalorias.service;

import _0.ejercicio_calculadoracalorias.dto.PlatoDTO;
import _0.ejercicio_calculadoracalorias.model.Ingredientes;
import _0.ejercicio_calculadoracalorias.model.Plato;

import java.util.List;

public interface PlatoService {

    public PlatoDTO calcularCalorias(String n);

}
