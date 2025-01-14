package org.bootcamp.arquitecturamulticapap2.repository;

import org.bootcamp.arquitecturamulticapap2.dto.response.IngredienteDTO_Out;
import org.bootcamp.arquitecturamulticapap2.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository {
    private ObjectMapper mapper;
    private final static String FILE_PATH = "src/main/resources/food.json";
    private List<Ingrediente> ingredienteBD;

    public IngredienteRepositoryImpl(){
        this.mapper = new ObjectMapper();
        this.cargarDatos();
    }

    private void cargarDatos(){
        try{
            String content = Files.readString(Paths.get(FILE_PATH));
            this.ingredienteBD = mapper.readValue(content, new TypeReference<List<Ingrediente>>(){});
        } catch (Exception e){
            e.printStackTrace();
            this.ingredienteBD = List.of();
        }
    }

    @Override
    public IngredienteDTO_Out getByName(String name) {
        return this.ingredienteBD.stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .map(i -> mapper.convertValue(i, IngredienteDTO_Out.class))
                .findFirst()
                .orElse(null);
    }
}