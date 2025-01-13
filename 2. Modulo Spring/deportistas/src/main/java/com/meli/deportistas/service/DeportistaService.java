package com.meli.deportistas.service;

import com.meli.deportistas.model.DeportistaDTO;
import com.meli.deportistas.repository.DeportistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeportistaService {

    @Autowired
    private DeportistaRepository deportistaRepository;

    public List<DeportistaDTO> findAll() {
        return deportistaRepository.getDeportistaDTOS();
    }
}
