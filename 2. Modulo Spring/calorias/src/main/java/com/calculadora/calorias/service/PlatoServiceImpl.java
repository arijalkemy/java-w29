package com.calculadora.calorias.service;

import com.calculadora.calorias.model.Plato;
import com.calculadora.calorias.repository.PlatoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements IPlatoService {
    private PlatoRepositoryImpl platoRepository;

    @Autowired
    public PlatoServiceImpl(PlatoRepositoryImpl platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public List<Plato> findAll() {
        return this.platoRepository.getPlatos();
    }

    @Override
    public Optional<Plato> findPlatoByName(String name) {
        return this.platoRepository.getPlato(name);
    }
}
