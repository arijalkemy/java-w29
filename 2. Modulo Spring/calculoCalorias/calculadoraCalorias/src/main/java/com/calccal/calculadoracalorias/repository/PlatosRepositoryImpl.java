package com.calccal.calculadoracalorias.repository;

import com.calccal.calculadoracalorias.model.Ingrediente;
import com.calccal.calculadoracalorias.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatosRepositoryImpl implements IPlatosRepository{
    private List<Ingrediente> listaDeIngredientes = new ArrayList<>();
    private List<Plato> listaDePlatos = new ArrayList<>();

    private PlatosRepositoryImpl() throws IOException {
        loadDataBase();
        crearPlatos();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingrediente> ingredientes ;

        file= ResourceUtils.getFile("classpath:1. c. food 2.json");
        ingredientes = objectMapper.readValue(file,new TypeReference<List<Ingrediente>>(){});

        listaDeIngredientes = ingredientes;
    }

    private void crearPlatos(){
        Plato pastelManzana = new Plato("Pastel de manzana", List.of(
                listaDeIngredientes.stream().filter(i -> i.getName().equals("Pastel de manzana")).findFirst().orElse(null)
        ));

        Plato pastelQuesoYWhisky = new Plato("Pastel de queso", List.of(
                listaDeIngredientes.stream().filter(i -> i.getName().equals("Pastel de queso")).findFirst().orElse(null),
                listaDeIngredientes.stream().filter(i -> i.getName().equals("Whisky")).findFirst().orElse(null)
        ));

        Plato ensalada = new Plato("Ensalada", List.of(
                listaDeIngredientes.stream().filter(i -> i.getName().equals("Gambas")).findFirst().orElse(null),
                listaDeIngredientes.stream().filter(i -> i.getName().equals("Langostino")).findFirst().orElse(null),
                listaDeIngredientes.stream().filter(i -> i.getName().equals("Aceitunas negras")).findFirst().orElse(null),
                listaDeIngredientes.stream().filter(i -> i.getName().equals("Salsa de soja")).findFirst().orElse(null),
                listaDeIngredientes.stream().filter(i -> i.getName().equals("Aceite de oliva")).findFirst().orElse(null)
        ));

        listaDePlatos.add(pastelManzana);
        listaDePlatos.add(pastelQuesoYWhisky);
        listaDePlatos.add(ensalada);
    }

    @Override
    public List<Ingrediente> findAllIngr() {
        return listaDeIngredientes;
    }

    @Override
    public List<Plato> findAllPlatos() {
        return listaDePlatos;
    }

    @Override
    public Plato findPlatoByName(String nombrePlato) {
        return listaDePlatos.stream().
                filter(p -> p.getName().equalsIgnoreCase(nombrePlato))
                .findFirst().orElse(null);
    }

}


/*Ingrediente pastelManzana = listaDeIngredientes.stream().filter(i -> i.getName().equals("Pastel de manzana")).findFirst().orElse(null);
    Ingrediente pastelQueso = listaDeIngredientes.stream().filter(i -> i.getName().equals("Pastel de queso")).findFirst().orElse(null);
    Ingrediente pastelManzanaHojaldre = listaDeIngredientes.stream().filter(i -> i.getName().equals("Pastel de manzana, masa hojaldre")).findFirst().orElse(null);
    Ingrediente gambas = listaDeIngredientes.stream().filter(i -> i.getName().equals("Gambas")).findFirst().orElse(null);
    Ingrediente langostino = listaDeIngredientes.stream().filter(i -> i.getName().equals("Langostino")).findFirst().orElse(null);
    Ingrediente aceitunasNegras = listaDeIngredientes.stream().filter(i -> i.getName().equals("Aceitunas negras")).findFirst().orElse(null);
    Ingrediente salsaSoja = listaDeIngredientes.stream().filter(i -> i.getName().equals("Salsa de soja")).findFirst().orElse(null);
    Ingrediente aceiteOliva = listaDeIngredientes.stream().filter(i -> i.getName().equals("Aceite de oliva")).findFirst().orElse(null);*/
