package com.ejercicio.covid.service;

import com.ejercicio.covid.model.Persona;
import com.ejercicio.covid.model.Sintoma;
import com.ejercicio.covid.repository.PersonasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    PersonasRepository personasRepository;

    public PersonaService(PersonasRepository personasRepository) {
        this.personasRepository = personasRepository;
        Persona p1 = new Persona(1, "Camilo", "Mendez", 22, List.of());
        Persona p2 = new Persona(2, "Pepito", "Perez", 61, List.of(new Sintoma(1, "Fiebre", 5)));
        Persona p3 = new Persona(3, "Daniela", "Castro", 64, List.of());
        this.personasRepository.add(p1);
        this.personasRepository.add(p2);
        this.personasRepository.add(p3);
    }

    public List<Persona> getPersonasMayoresConSintomas() {
        return this.personasRepository.getPersonasMayoresConSintomas();
    }
}
