package com.bootcamp.deportista.service;

import com.bootcamp.deportista.dto.DeportistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DeportistaService {
    @Autowired
    private SportService sportService;
    @Autowired
    private PersonService personService;


    public List<DeportistaDTO> getDeportistas(){
        DeportistaDTO deportista1 = new DeportistaDTO(personService.getPerson("SomePerson"), sportService.basket);
        DeportistaDTO deportista2 = new DeportistaDTO(personService.getPerson("AnotherPerson"), sportService.football);
        List<DeportistaDTO> deportistas = Arrays.asList(deportista1, deportista2);
        return deportistas;
    }
}


