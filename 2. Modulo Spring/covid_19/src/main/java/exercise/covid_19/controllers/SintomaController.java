package exercise.covid_19.controllers;

import exercise.covid_19.dtos.PersonaDTO;
import exercise.covid_19.models.Persona;
import exercise.covid_19.models.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SintomaController {

    List<Sintoma> sintomas;
    List<Persona> personas;

    public SintomaController() {
        sintomas = new ArrayList<>(List.of(
                new Sintoma("S001", "Fiebre", "Moderado"),
                new Sintoma("S002", "Tos seca", "Moderado"),
                new Sintoma("S003", "Cansancio", "Leve"),
                new Sintoma("S004", "Pérdida olfato", "Moderado")
        ));

        personas = new ArrayList<>(List.of(
                new Persona(1, "Juan", "Pérez", 65),
                new Persona(2, "María", "Gómez", 32),
                new Persona(3, "Carlos", "López", 15),
                new Persona(4, "Ana", "Martínez", 82)
        ));

    }

    @GetMapping("/findSymptom")
    public List<Sintoma> getAllSintomas(){
        return sintomas;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSintomaPorNombre(@PathVariable String name){
        String resultado = "";
        Optional<Sintoma> sintoma = sintomas.stream().filter(s -> s.getNombre().equalsIgnoreCase(name)).findFirst();

        if(sintoma.isPresent()){
            resultado = "El nivel de gravedad es: " + sintoma.get().getNivelGravedad();

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            resultado = "Síntoma no encontrado";

            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> getAllPersonas(){
        List<PersonaDTO> listaDto = new ArrayList<>();

        List<Persona> listaPersonasMayorA60 = personas.stream()
                .filter(p -> p.getEdad() >= 60).toList();

        for (int i = 0; i < listaPersonasMayorA60.size(); i++) {
            PersonaDTO personaDTO = new PersonaDTO();
            Persona persona = personas.get(i);
            Sintoma sintoma = sintomas.get(i);

            String nombreCompleto = persona.getNombre() + " " + persona.getApellido();

            personaDTO.setNombreCompleto(nombreCompleto);
            personaDTO.setSintoma(sintoma.getNombre());

            listaDto.add(personaDTO);
        }

        return listaDto;
    }


}
