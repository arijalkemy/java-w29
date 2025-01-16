package org.example.ej_calculadora_calorias.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ej_calculadora_calorias.Entity.Ingrediente;
import org.example.ej_calculadora_calorias.Entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {

    private List<Ingrediente> ingredientes = new ArrayList<>();
    private List<Plato> platos = new ArrayList<>();


    public PlatoRepositoryImpl() throws IOException {

        loadDataBase();
        platos.add(new Plato("Pizza", List.of(ingredientes.get(5), ingredientes.get(10), ingredientes.get(1))));
        platos.add(new Plato("Fideos", List.of(ingredientes.get(12), ingredientes.get(10), ingredientes.get(2))));
        platos.add(new Plato("Milanesa", List.of(ingredientes.get(11), ingredientes.get(9), ingredientes.get(5))));
        platos.add(new Plato("Ensalada", List.of(ingredientes.get(5), ingredientes.get(10))));
    }


  /*  private void loadData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = TypeReference.class.getResourceAsStream("/food.json");
            ingredientes = mapper.readValue(is, new TypeReference<List<Ingrediente>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingrediente> foods;

        file = ResourceUtils.getFile("classpath:food.json");
        foods = objectMapper.readValue(file,new TypeReference<List<Ingrediente>>(){});

        this.ingredientes = foods;
    }

    @Override
    public List<Plato> getByNomes(List<String> names) {
        return platos
                .stream()
                .filter(d -> names.contains(d.getNombre())).toList();
    }

    @Override
    public Optional<Plato> getByName(String name) {
        return platos
                .stream().
                filter(plato -> plato.getNombre().equalsIgnoreCase(name)).findFirst();

    }
}
