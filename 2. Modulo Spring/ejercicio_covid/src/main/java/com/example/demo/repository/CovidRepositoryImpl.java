package com.example.demo.repository;


import com.example.demo.model.Personas;
import com.example.demo.model.Sintomas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CovidRepositoryImpl implements ICovidrepository {
    List<Sintomas> listOfSintomas = new ArrayList<>();

    List<Personas> listOfPerson = new ArrayList<>();

    public CovidRepositoryImpl() {
        cargarSintomas();
    }

    private void cargarSintomas(){
        // Agregar datos a la lista
        listOfSintomas.add(new Sintomas(1, "Fiebre", 3));
        listOfSintomas.add(new Sintomas(2, "Dolor de cabeza", 2));
        listOfSintomas.add(new Sintomas(3, "Tos persistente", 4));
        listOfSintomas.add(new Sintomas(4, "Dolor muscular", 2));
        listOfSintomas.add(new Sintomas(5, "Dificultad para respirar", 5));
        listOfSintomas.add(new Sintomas(6, "Dolor de garganta", 2));
        listOfSintomas.add(new Sintomas(7, "Fatiga", 3));
        listOfSintomas.add(new Sintomas(8, "Pérdida de apetito", 2));
        listOfSintomas.add(new Sintomas(9, "Erupción cutánea", 3));
        listOfSintomas.add(new Sintomas(10, "Vómitos", 4));
    }

    private void cargarPersonas(){
        // Personas mayores de 60 años con síntomas asociados
        listOfPerson.add(new Personas(1L, "Juan", "Pérez", 65, List.of(listOfSintomas.get(0), listOfSintomas.get(3))));
        listOfPerson.add(new Personas(2L, "María", "Gómez", 70, List.of(listOfSintomas.get(4), listOfSintomas.get(6))));

        // Personas mayores de 60 años sin síntomas
        listOfPerson.add(new Personas(3L, "Luis", "Rodríguez", 68, new ArrayList<>()));

        // Personas menores de 60 años con síntomas asociados
        listOfPerson.add(new Personas(4L, "Ana", "Martínez", 30, List.of(listOfSintomas.get(2), listOfSintomas.get(7))));
        listOfPerson.add(new Personas(5L, "Pedro", "López", 45, List.of(listOfSintomas.get(1), listOfSintomas.get(9))));

        // Personas menores de 60 años sin síntomas
        listOfPerson.add(new Personas(6L, "Sofía", "Hernández", 25, new ArrayList<>()));

    }




    @Override
    public List<Sintomas> findSintomas() {
        return listOfSintomas;
    }

    @Override
    public Optional<Sintomas> findByName(String n) {
        Optional<Sintomas> s = listOfSintomas.stream().filter(sintoma->sintoma.getNombre().equalsIgnoreCase(n)).findFirst();
        return s;
    }

    @Override
    public List<Personas> findPersonasGrupoRiesgo() {
        return listOfPerson
                .stream()
                .filter(p->p.getEdad()>60 && p.getSintomasasociados().size()>0)
                .toList();
    }
}
