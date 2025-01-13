package com.practicaedaddepersona.practicadeedadeunapersona.controllers;

import com.practicaedaddepersona.practicadeedadeunapersona.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api/persona")
public class PersonaRestController {

    @GetMapping("/{day}/{month}/{year}")
    public String calculoEdadPersona(@PathVariable String day, @PathVariable String month, @PathVariable String year) {
        try {
            // Convertir los parámetros a enteros
            int dia = Integer.parseInt(day);
            int mes = Integer.parseInt(month);
            int anio = Integer.parseInt(year);

            // Crear la fecha de nacimiento
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

            // Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();

            // Calcular la edad
            int edad = Period.between(fechaNacimiento, fechaActual).getYears();

            // Devolver la edad
            return edad + "años";

        } catch (NumberFormatException e) {
            // Manejar el caso en que los parámetros no sean números enteros
            return "Error: Los valores ingresados deben ser números enteros.";
        } catch (Exception e) {
            // Manejar otros errores, como fechas inválidas
            return "Error: Verifique que la fecha ingresada sea válida.";
        }
    }

    @PostMapping("/calcular-edad")
    public ResponseEntity<String> calcularEdad(@RequestBody Persona persona) {
        try {
            // Parsear la fecha de nacimiento
            LocalDate fechaNacimiento = LocalDate.parse(persona.getFechaNacimiento());
            LocalDate fechaActual = LocalDate.now();

            // Calcular la edad
            int edad = Period.between(fechaNacimiento, fechaActual).getYears();

            // Retornar el ID y la edad calculada
            return ResponseEntity.ok("ID: " + persona.getId() + ", Edad calculada: " + edad);
        } catch (DateTimeParseException e) {
            // Manejar errores de formato de fecha
            return ResponseEntity.badRequest().body("Error: Formato de fecha inválido. Use 'yyyy-MM-dd'.");
        } catch (Exception e) {
            // Manejar otros errores
            return ResponseEntity.badRequest().body("Error: Ocurrió un problema al calcular la edad.");
        }
    }

    @GetMapping("/hola")
    ResponseEntity<String> holaMundo(){
        return new ResponseEntity<>("Hola Mundo desde una respuesta HTTP",HttpStatus.OK);
    }
}
