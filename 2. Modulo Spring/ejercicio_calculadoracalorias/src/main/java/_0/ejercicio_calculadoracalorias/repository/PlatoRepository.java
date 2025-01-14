package _0.ejercicio_calculadoracalorias.repository;

import _0.ejercicio_calculadoracalorias.model.Ingredientes;
import _0.ejercicio_calculadoracalorias.model.Plato;

public interface PlatoRepository {
    public Plato findByName(String name);

}
