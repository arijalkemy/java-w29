package com.meli.starwars.repository;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.meli.starwars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    private static final String FILE_PATH = "./personajes.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public PersonajeRepositoryImpl() {
        File file = new File(FILE_PATH);
        try {
            if (file.createNewFile()) {
                saveAll(new ArrayList<Personaje>());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAll(List<Personaje> personajes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String json = gson.toJson(personajes);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Personaje> getPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Type userListType = new TypeToken<List<Personaje>>() {}.getType();
            personajes = gson.fromJson(reader, userListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

    public List<Personaje> searchByName(String name) {
        String nameLower = name.toLowerCase();

        return this.getPersonajes().stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(nameLower))
                .toList();
    }

}
