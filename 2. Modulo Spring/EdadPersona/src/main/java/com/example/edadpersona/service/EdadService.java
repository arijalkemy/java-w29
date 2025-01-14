package com.example.edadpersona.service;

import com.example.edadpersona.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Service // Anotación para indicar que esta clase es un servicio
public class EdadService {
    private final Map<Integer, Usuario> usuarios = new HashMap<>();
    private Integer idActual = 1;

    public Integer agregarUsuario(LocalDate fechaNacimiento) {
        Usuario usuario = new Usuario(idActual, fechaNacimiento);
        usuarios.put(idActual, usuario);
        return idActual++;
    }

    public String calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();

        if (fechaNacimiento.isAfter(fechaActual)) {
            return "La fecha de nacimiento debe ser antes de la actual";
        }

        Integer edad = Period.between(fechaNacimiento, fechaActual).getYears();
        return "La edad es: " + edad + " años";
    }

    public String EdadPorId(Integer id) {
        Usuario usuario = usuarios.get(id);
        if (usuario == null) {
            return "El usuario no existe";
        }
        return calcularEdad(usuario.getFechaNacimiento());
    }
}