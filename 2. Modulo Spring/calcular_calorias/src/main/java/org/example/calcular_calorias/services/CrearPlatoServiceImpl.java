package org.example.calcular_calorias.services;

import org.example.calcular_calorias.dtos.PlatosDto;
import org.example.calcular_calorias.entities.Platos;
import org.example.calcular_calorias.repositories.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CrearPlatoServiceImpl implements ICrearPlatoService {
    @Autowired
    private IPlatoRepository platoRepository; // Inyección del repositorio para acceder a los platos

    @Override
    public void crearPlato(PlatosDto platosDto) {
        // Convertir PlatosDto a entidad Platos
        Platos nuevoPlato = new Platos();
        nuevoPlato.setNombre(platosDto.getNombre());
        nuevoPlato.setPeso(platosDto.getPesoGramos());
        nuevoPlato.setIngredientes(new ArrayList<>());
    }
}