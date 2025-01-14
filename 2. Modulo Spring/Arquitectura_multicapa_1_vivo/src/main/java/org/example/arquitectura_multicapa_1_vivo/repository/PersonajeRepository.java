package org.example.arquitectura_multicapa_1_vivo.repository;

import org.example.arquitectura_multicapa_1_vivo.entity.Personaje;

import java.util.ArrayList;
import java.util.List;

public interface PersonajeRepository {
    List<Personaje> buscarPorNombre(String nombre);



}
