package org.example.ej_calculadora_calorias.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ej_calculadora_calorias.Dto.IngredienteDTO;
import org.example.ej_calculadora_calorias.Dto.PlatoDTO;
import org.example.ej_calculadora_calorias.Entity.Ingrediente;
import org.example.ej_calculadora_calorias.Entity.Plato;
import org.example.ej_calculadora_calorias.Exception.NoFoundException;
import org.example.ej_calculadora_calorias.Repository.PlatoRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements IPlatoService {

    private final PlatoRepositoryImpl repository;

    public PlatoServiceImpl(PlatoRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Integer getCalorias(String plato) {

        Optional<Plato> optionalPlato = repository.getByName(plato);
        if (optionalPlato.isEmpty()) {
            throw new NoFoundException("Plato no existente:  " + plato);
        }
        return optionalPlato.get().getIngredientes().stream().mapToInt(Ingrediente::getCalories).sum();
    }

    @Override
    public List<IngredienteDTO> getIngredientes(String plato) {
        Optional<Plato> optionalPlato = repository.getByName(plato);
        if (optionalPlato.isEmpty()) {
            throw new NoFoundException("Plato no existente:  " + plato);
        }

        return optionalPlato.get()
                .getIngredientes()
                .stream()
                .map(f -> new IngredienteDTO(f.getName(), f.getCalories())).toList();
    }

    @Override
    public IngredienteDTO maxCalorias(String plato) {
        Optional<Plato> optionalPlato = repository.getByName(plato);
        if (optionalPlato.isEmpty()) {
            throw new NoFoundException("Plato no existente:  " + plato);
        }

        Ingrediente ingrediente = optionalPlato.get()
                .getIngredientes()
                .stream()
                .max((f1, f2) -> f1.getCalories().compareTo(f2.getCalories())).orElseThrow();

        return new IngredienteDTO(ingrediente.getName(), ingrediente.getCalories());
    }
}
