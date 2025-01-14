package spring.ejerciciostarwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ejerciciostarwars.dto.PersonajeDTO;
import spring.ejerciciostarwars.model.Personaje;
import spring.ejerciciostarwars.repository.IPersonajeRepository;

import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {
    private final IPersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> findByName(String name) {
        List<Personaje> personajes = personajeRepository.findByName(name);
        ObjectMapper objectMapper = new ObjectMapper();

        return personajes.stream()
                .map(this::mapToDTO)
                .toList();
    }

    private PersonajeDTO mapToDTO(Personaje personaje) {
        Integer height = null;
        Integer mass = null;
        try {
            height = Integer.parseInt(personaje.height());
            mass = Integer.parseInt(personaje.mass());
        } catch (NumberFormatException e) {
        }
        return new PersonajeDTO(personaje.name(), height, mass, personaje.gender(), personaje.homeworld(), personaje.species());
    }
}
