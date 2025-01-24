package com.example.demo.dto;

import com.example.demo.model.Personaje;

public record PersonajeDTO (
        String nombre,
        int altura,
        int masa,
        String genero,
        String mundoNatal,
        String especie
){
    public static PersonajeDTO convertirDTO(Personaje personaje) {
        return new PersonajeDTO(
                personaje.getName(),
                personaje.getHeight(),
                personaje.getMass(),
                personaje.getGender(),
                personaje.getHomeworld(),
                personaje.getSpecies());
    }

    public boolean contieneValor(String valor) {
        if(valor == null || valor.isBlank()) {
            return false;
        } else {
        return (nombre.contains(valor)) ||
                (altura == Integer.parseInt(valor)) ||
                (masa == Integer.parseInt(valor)) ||
                (genero.contains(valor)) ||
                (mundoNatal.contains(valor)) ||
                (especie.contains(valor));
        }
    }
}
