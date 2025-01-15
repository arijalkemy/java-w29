package exercise.calculadora_calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.calculadora_calorias.entity.Ingrediente;
import exercise.calculadora_calorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository{

    private List<Ingrediente> ingredientes; // Ingrediente de la lista
    private List<Plato> platos; // Platos definidos con ingredientes
    public PlatoRepositoryImpl() {
        cargarIngredientes();
        cargarPlatos();
    }

    @Override
    public Plato getPlato(String nombre) {
        return platos.stream().filter(plato -> plato.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    private void cargarIngredientes() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ingredientes = mapper.readValue(
                    getClass().getResourceAsStream("/json/ingredientes.json"),
                    new TypeReference<List<Ingrediente>>() {}
            );
        } catch (IOException e) {
            e.printStackTrace();
            ingredientes = List.of();
        }
    }
    private void cargarPlatos() {
        platos = new ArrayList<>();
        // Asegúrate de usar nombres y cantidades correctos y que existan en `ingredientes`
        Plato ensaladaMixta = new Plato("Ensalada Mixta", Map.of(
                buscarIngrediente("Lechuga"), 1,
                buscarIngrediente("Tomates"), 2,
                buscarIngrediente("Aceitunas verdes"), 10
        ));
        Plato sopaVerduras = new Plato("Sopa de Verduras", Map.of(
                buscarIngrediente("Cebolla"), 1,
                buscarIngrediente("Zanahoria"), 2,
                buscarIngrediente("Brócoli"), 1
        ));
        Plato pizzaVegetariana = new Plato("Pizza Vegetariana", Map.of(
                buscarIngrediente("Queso mozzarella"), 1,
                buscarIngrediente("Tomates"), 1,
                buscarIngrediente("Pimiento"), 1
        ));
        // Añadir platos a la lista
        platos.add(ensaladaMixta);
        platos.add(sopaVerduras);
        platos.add(pizzaVegetariana);
    }

    private Ingrediente buscarIngrediente(String name) {
        return ingredientes.stream()
                .filter(ingrediente -> ingrediente.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Ingrediente no encontrado: " + name));
    }


}
