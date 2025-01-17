package com.example.__persona.controller;

import com.example.__persona.dto_out.PersonaDTO_In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    // parte 1
    @GetMapping("/{dia}/{mes}/{agno}")
    public Integer devolverEdad(@PathVariable Integer dia,
                                @PathVariable Integer mes,
                                @PathVariable Integer agno){
        LocalDate fechaNacimiento = LocalDate.of(agno, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaNacimiento, fechaActual);

        return period.getYears();
    }

}
