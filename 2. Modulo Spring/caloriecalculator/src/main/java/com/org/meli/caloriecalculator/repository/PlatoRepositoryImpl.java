package com.org.meli.caloriecalculator.repository;

import com.org.meli.caloriecalculator.entity.Ingrediente;
import com.org.meli.caloriecalculator.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {
    private final IIngredienteRepository ingredienteRepository;
    private final List<Plato> platos;

    public PlatoRepositoryImpl(IIngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;

        List<Ingrediente> ingredientesPizza = ingredienteRepository.obtenerIngredientes()
                .stream()
                .filter(ingrediente -> ingrediente.getNombre().equals("Queso mozzarella")
                        || ingrediente.getNombre().equalsIgnoreCase("Harina de trigo integral")
                        || ingrediente.getNombre().equalsIgnoreCase("Salsa de tomate en conserva")
                        || ingrediente.getNombre().equalsIgnoreCase("Jamón crudo")
                        || ingrediente.getNombre().equalsIgnoreCase("Piña"))
                .toList();
        Integer caloriasPizza = ingredientesPizza.stream().mapToInt(Ingrediente::getCalorias).sum();

        List<Ingrediente> ingredientesPanChorizoQueso = ingredienteRepository.obtenerIngredientes()
                .stream()
                .filter(ingrediente -> ingrediente.getNombre().equalsIgnoreCase("Pan de centeno")
                        || ingrediente.getNombre().equalsIgnoreCase("Chorizo")
                        || ingrediente.getNombre().equalsIgnoreCase("Queso de bola"))
                .toList();
        Integer caloriasPanChorizoQueso = ingredientesPanChorizoQueso.stream().mapToInt(Ingrediente::getCalorias).sum();

        List<Ingrediente> ingredientesPolloConEnsalada = ingredienteRepository.obtenerIngredientes()
                .stream()
                .filter(ingrediente -> ingrediente.getNombre().equalsIgnoreCase("Lechuga")
                        || ingrediente.getNombre().equalsIgnoreCase("Zanahoria")
                        || ingrediente.getNombre().equalsIgnoreCase("Pollo")
                        || ingrediente.getNombre().equalsIgnoreCase("Pepino"))
                .toList();
        Integer caloriasPolloConEnsalada = ingredientesPolloConEnsalada.stream().mapToInt(Ingrediente::getCalorias).sum();

        platos = List.of(
                new Plato("Pizza de pepperoni", ingredientesPizza, caloriasPizza),
                new Plato("Pan con chorizo y queso", ingredientesPanChorizoQueso, caloriasPanChorizoQueso),
                new Plato("Pollo con ensalada", ingredientesPolloConEnsalada, caloriasPolloConEnsalada)
        );
    }

    @Override
    public Plato buscarPlatoPorNombre(String nombrePlato) {
        return platos.stream().filter(plato -> plato.getNombre().equalsIgnoreCase(nombrePlato)).findFirst().orElse(null);
    }

    @Override
    public Ingrediente buscarIngredienteConMasCalorias(String nombrePlato) {
        Plato plato = buscarPlatoPorNombre(nombrePlato);
        if (plato == null) {
            return null;
        }
        return plato.getIngredientes().stream().max(Comparator.comparing(Ingrediente::getCalorias)).orElse(null);

    }
}