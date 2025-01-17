package spring.ejerciciocalculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import spring.ejerciciocalculadoracalorias.model.Ingrediente;
import spring.ejerciciocalculadoracalorias.model.Plato;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Repository
public class RestaurantRepository implements IRestaurantRepository {
    private final List<Ingrediente> ingredientes;
    private final List<Plato> platos;

    public RestaurantRepository() {
        this.ingredientes = readFromJsonFile("food.json", new TypeReference<>() {
        });
        this.platos = readFromJsonFile("platos.json", new TypeReference<>() {
        });
    }


    public static <T> T readFromJsonFile(String jsonFileName, TypeReference<T> typeReference) {
        try {
            final File jsonFile = new ClassPathResource(jsonFileName).getFile();
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonFile, typeReference);
        } catch (IOException e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ingrediente getIngredienteByName(String name) {
        return ingredientes.stream()
                .filter(i -> Objects.equals(i.getNombre(), name))
                .findFirst().orElse(null);
    }

    @Override
    public Plato getPlatoByName(String name) {
        return platos.stream()
                .filter(i -> Objects.equals(i.getNombre(), name))
                .findFirst().orElse(null);
    }

    @Override
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
}
