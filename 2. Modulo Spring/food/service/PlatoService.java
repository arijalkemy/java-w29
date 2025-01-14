package com.api.food.service;

import com.api.food.entity.Plato;
import com.api.food.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {

    // @Autowired // se puede
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
