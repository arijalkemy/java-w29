package com.bootcamp.food.service;

import com.bootcamp.food.entity.Plato;
import com.bootcamp.food.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {
    private final PlatoRepository platoRepository;
    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }
    public Plato getPlatoByName(String name){
        return this.platoRepository.getPlatoByName(name);
    }
    public List<Plato> getAll(){
        return this.platoRepository.getPlatos();
    }
}
