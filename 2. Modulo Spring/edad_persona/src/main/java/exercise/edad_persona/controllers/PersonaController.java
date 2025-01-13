package exercise.edad_persona.controllers;

import exercise.edad_persona.dtos.PersonaDto;
import exercise.edad_persona.models.Persona;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private List<Persona> personas = new ArrayList<>();

    @PostMapping
    public Persona addPersona(@RequestBody PersonaDto personaDto) {
        Random random = new Random();

        int idPersona = random.nextInt(1000);

        Persona nuevaPersona = new Persona(idPersona, personaDto.getNombre(), personaDto.getFechaNacimiento());

        personas.add(nuevaPersona);

        return nuevaPersona;
    }

    @GetMapping("/{id}")
    public int obtenerEdadPorId(@PathVariable int id) {
        Optional<Persona> personaEncontrada = personas.stream().filter(persona -> persona.getId() == id).findFirst();

        if(personaEncontrada.isPresent()){
            int[] fechaNacimiento = Arrays.stream(personaEncontrada.get().getFechaNacimiento().split("/")).mapToInt(Integer::parseInt).toArray();

            int dia = fechaNacimiento[0];
            int mes = fechaNacimiento[1];
            int ano = fechaNacimiento[2];

            LocalDate fechaCumpleanos = LocalDate.of(ano, mes, dia);
            LocalDate fechaActual = LocalDate.now();

            return Period.between(fechaCumpleanos, fechaActual).getYears();
        } else {
            return 0;
        }
    }
}
