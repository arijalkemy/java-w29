package com.meli.starwars.service;

import com.meli.starwars.dto.response.PersonajeResponseDTO;
import com.meli.starwars.repository.IPersonajeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PersonajesServiceTest {

    @Autowired
    private PersonajeServiceImpl personajeService;

    @Test
    public void searchByNameTest() {
        String name = "Luke";

        List<PersonajeResponseDTO> personajes = personajeService.searchByName(name);
        personajes.forEach(personaje -> assertTrue(personaje.getName().toLowerCase().contains(name.toLowerCase())));
    }

}
