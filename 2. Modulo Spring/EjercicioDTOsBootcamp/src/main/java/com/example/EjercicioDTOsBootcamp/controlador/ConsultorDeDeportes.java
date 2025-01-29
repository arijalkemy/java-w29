package com.example.EjercicioDTOsBootcamp.controlador;

import com.example.EjercicioDTOsBootcamp.DTO.DTODeportes;
import com.example.EjercicioDTOsBootcamp.DTO.DTOPersonaDeporte;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConsultorDeDeportes {
    List<DTODeportes> deportes = new ArrayList<>();
    DTODeportes deporte1 = new DTODeportes("futbol", "basico");
    DTODeportes deporte2 = new DTODeportes("tenis", "avanzado");
    DTODeportes deporte3 = new DTODeportes("voley", "medio");

    DTOPersonaDeporte deportePersona1 = new DTOPersonaDeporte("juan", "perez", deporte1.getNombre());
    DTOPersonaDeporte deportePersona2 = new DTOPersonaDeporte("Pablo", "Rerez", deporte2.getNombre());

    List<DTOPersonaDeporte> personasDeportes = new ArrayList<>();

    @GetMapping("/findSports")
    public String ConsultarDeDeportes() {
        deportes.add(deporte1);
        deportes.add(deporte2);
        deportes.add(deporte3);
        return deportes.toString();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> ConsultarDeDeportes(@PathVariable String name) {
        String nivel = "";
        deportes.add(deporte1);
        deportes.add(deporte2);
        deportes.add(deporte3);
        for (DTODeportes deporte : deportes) {
            if (deporte.getNombre().equals(name)) {
                nivel = deporte.getNivel();
                break;
            }
        }
        if (nivel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nivel);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<String> ConsultarDeDeportesPersons() {
        personasDeportes.add(deportePersona1);
        personasDeportes.add(deportePersona2);

        return ResponseEntity.ok(personasDeportes.toString());
    }
}
