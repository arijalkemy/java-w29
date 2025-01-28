package org.example.deportes.Services;


import org.example.deportes.DTO.DeportistaDTO;
import org.example.deportes.Entity.Deporte;
import org.example.deportes.Entity.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Services {

    private List<Deporte> deportes;
    private List<Persona> personas;

    // Inicializamos las listas con algunos datos de ejemplo
    public Services() {
        deportes = new ArrayList<>();
        deportes.add(new Deporte("Fútbol", "Avanzado"));
        deportes.add(new Deporte("Tenis", "Intermedio"));

        personas = new ArrayList<>();
        personas.add(new Persona("Juan", "Pérez", 25));
        personas.add(new Persona("María", "González", 30));
    }

    public List<Deporte> getSports() {
        return deportes;
    }

    public Deporte findSportByName(String name) {
        // Busca un deporte por su nombre
        for (Deporte deporte : deportes) {
            if (deporte.getNombreDeporte().equalsIgnoreCase(name)) {
                return deporte;
            }
        }
        return null;
    }

    public List<DeportistaDTO> getSportsPersons() {
        // Crea una lista DTO de personas deportistas
        List<DeportistaDTO> deportistasDTO = new ArrayList<>();

        for (Persona persona : personas) {
            // Solo se muestra el nombre completo y el deporte.
            // Aquí puedes cambiar la lógica según tus requerimientos.
            deportistasDTO.add(new DeportistaDTO(persona.getNombre() + " " + persona.getApellido(), "Fútbol"));
        }
        return deportistasDTO;
    }
}
