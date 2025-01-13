package com.example.demo.service;

import com.example.demo.model.Deporte;

import java.util.List;

public interface DeporteService {
 // Nuestra aplicación deberá contar con la siguiente funcionalidad:
//Ver todos los deportes que tenemos cargados.
    //PATH: /findSports
//Consultar si existe un deporte ingresando su nombre. De existir, se deberá mostrar el nivel del mismo.
// Utilizar la clase ResponseEntity para devolver la respuesta.
    //PATH: /findSport/{name}

     List<Deporte> verDeportes();

     Deporte buscarPorNombre(String nombre);

     public void saveDeporte( Deporte deporte);



}
