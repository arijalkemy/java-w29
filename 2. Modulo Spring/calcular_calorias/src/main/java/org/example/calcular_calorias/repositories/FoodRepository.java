package org.example.calcular_calorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calcular_calorias.entities.Platos;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepository implements IPlatoRepository {
    private List<Platos> platos; // Lista donde se almacenarán los platos

    public FoodRepository() {
        cargarDatosDesdeJSON(); // Cargar datos al inicializar el repositorio
    }

    private void cargarDatosDesdeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Ajusta la ruta según la ubicación real de tu archivo food.json
            File file = new File("src/main/resources/food.json"); // Asegúrate de que la ruta sea correcta
            platos = objectMapper.readValue(file, new TypeReference<List<Platos>>() {}); // Carga los datos del archivo JSON en la lista de platos
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
            // Podrías lanzar una excepción personalizada o manejar el error de otra manera
        }
    }

    @Override
    public List<Platos> obtenerPlatos() {
        return platos; // Retorna la lista de platos
    }

    @Override
    public Platos buscarPlatoPorNombre(String nombre) {
        return platos.stream()
                .filter(platos -> platos.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null); // Retorna el plato encontrado o null si no se encuentra
    }
}