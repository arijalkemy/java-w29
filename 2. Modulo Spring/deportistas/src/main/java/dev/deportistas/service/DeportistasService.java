package dev.deportistas.service;


import dev.deportistas.dto.DeporteDto;
import dev.deportistas.dto.ItemDeporteDto;
import dev.deportistas.dto.PersonsDto;
import dev.deportistas.entity.Deporte;
import dev.deportistas.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeportistasService {

    private List<Deporte> deportes;
    private Map<Deporte, List<Persona>> deportePersona;

    public DeportistasService() {
        this.deportes = new ArrayList<>();
        this.deportePersona = new HashMap<>();


        Deporte futbol = new Deporte("Futbol", 9);
        Deporte basket = new Deporte("Basket", 8);
        Deporte hockey = new Deporte("Hockey", 7);
        Deporte handball = new Deporte("Handball", 6);

        Persona person1 = new Persona("Pablo", "Berna", 17);
        Persona person2 = new Persona("Fede", "Parodi", 19);
        Persona person3 = new Persona("Martin", "Altamiranda", 20);

        deportes.add(futbol);
        deportes.add(basket);
        deportes.add(hockey);
        deportes.add(handball);

        deportePersona.put(futbol, new ArrayList<>(List.of(person1, person2)));
        deportePersona.put(hockey, new ArrayList<>(List.of(person3)));
    }

    public List<ItemDeporteDto> allSports(){
        return deportes.stream().map(s -> new ItemDeporteDto(s.getName()))
                    .collect(Collectors.toList());
    }

    public DeporteDto sportByName(String nameSport) {
        return deportes.stream()
                .filter(d -> d.getName().equals(nameSport))
                .map(d -> new DeporteDto(d.getName(), d.getNivel()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Sport not found: " + nameSport));
    }

    public List<PersonsDto> getPersonsBySport() {
        return deportePersona.entrySet().stream()
                .flatMap(dp -> dp.getValue().stream()
                        .map(p -> new PersonsDto( p.getName(), p.getLastname(), dp.getKey().getName())))
                .collect(Collectors.toList());
    }

}
