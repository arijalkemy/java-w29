package com.Covid_19.covid.Controller;

import com.Covid_19.covid.DTO.PersonaDTO;
import com.Covid_19.covid.DTO.SintomaDTO;
import com.Covid_19.covid.Model.Persona;
import com.Covid_19.covid.Model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CovidRestController {
    private final List<Persona> personas = new ArrayList<>();
    private final List<Sintoma> sintomas = new ArrayList<>();

    public CovidRestController(){
        sintomas.add(new Sintoma(1,"Fiebre Amarilla","1"));
        sintomas.add(new Sintoma(2,"Covid 19","2"));
        sintomas.add(new Sintoma(3,"Vaca Loca","3"));

        personas.add(new Persona(1,"juan","zagardia",37,sintomas.get(0)));
        personas.add(new Persona(1,"pepe","argento",22,sintomas.get(1)));
        personas.add(new Persona(1,"jose","armadillo",61,sintomas.get(2)));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getSintoma(){
        List<SintomaDTO> sintomaDto = new ArrayList<>();
        for (Sintoma s : sintomas)
        {
            sintomaDto.add(new SintomaDTO(s.getNombre(),s.getNivelGravedad()));
        }
        return new ResponseEntity<>(sintomaDto,HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> getGrupoRiesgo(){
        List<PersonaDTO> personaDto = new ArrayList<>();
        for (Persona p : personas)
        {
            if (p.getEdad()> 60) {
                personaDto.add(new PersonaDTO(p.getNombre(), p.getApellido(), p.getEdad(), p.getSintoma().getNombre()));
                return new ResponseEntity<>(personaDto, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> getSintomaByName(@PathVariable String name){
        for (Sintoma s : sintomas)
        {
            if (s.getNombre().equalsIgnoreCase(name)){
                SintomaDTO sintomaDTO = new SintomaDTO(s.getNombre(),s.getNivelGravedad());
                return  new ResponseEntity<>(sintomaDTO,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

