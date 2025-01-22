package dev.calories.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.calories.entity.Ingrediente;
import dev.calories.entity.Plato;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository{

    private List<Plato> platosList;
    private List<Ingrediente> ingredienteList;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public PlatoRepositoryImpl() {
        this.platosList = new ArrayList<>();
        this.ingredienteList = new ArrayList<>();
        this.cargarAlimentos();
    }

    private void cargarAlimentos(){

        try{
            File file = new File("src/main/resources/ingredientes.json");
            this.ingredienteList.addAll(this.objectMapper.readValue(file, new TypeReference<List<Ingrediente>>(){ }));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Optional<Plato> getPlatoByNombre(String nombre){
        return platosList.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

}
