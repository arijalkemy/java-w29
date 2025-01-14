package com.example.demo.repository;

import com.example.demo.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImp implements PersonajeRepository {

    //Cargar los datos de JSON
    private List<Personaje> personajesRepolist = new ArrayList<>();

    // Constructor para cargar datos desde el archivo JSON
    public PersonajeRepositoryImp() {
        cargarDatosDesdeJson();
    }

    // Método para cargar los datos desde el archivo JSON
    private void cargarDatosDesdeJson() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/personajejson.json")) {
            if (inputStream == null) {
                throw new IllegalArgumentException("El archivo personajes.json no se encuentra en el classpath");
            }
            // Cargar el archivo JSON en la lista
            List<Personaje> personajes = mapper.readValue(
                    inputStream,
                    new TypeReference<List<Personaje>>() {}
            );
            personajesRepolist.addAll(personajes);
            System.out.println("Datos cargados correctamente desde JSON");
        } catch (Exception e) {
            System.err.println("Error al cargar los datos del JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }





    //Buscar personaje por nombre
    @Override
    public List<Personaje> findAll() {
        return personajesRepolist;
    }
}
