package org.example.dto_responseentity_2;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaludService {
    @Autowired
    private DataRepository dataRepository;

    public List<Sintoma> getAllSymptoms() {
        return dataRepository.getSintomas();
    }

    public ResponseEntity<String> findSintomasByName(String name) {
        List<Sintoma> sintomas = dataRepository.getSintomas();
        for (Sintoma sintoma : sintomas) {
            if (sintoma.getNombre().equals(name)) {
                return ResponseEntity.ok("El sintoma " + name + " fue encontrado");
            }
        }
        return ResponseEntity.notFound().build();
    }

    public List<PersonaDTO> findRiskPersons() {
        return dataRepository.getPersonas().stream()
                .filter(persona -> persona.getEdad() > 60)
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido()))
                .toList();
    }


}
