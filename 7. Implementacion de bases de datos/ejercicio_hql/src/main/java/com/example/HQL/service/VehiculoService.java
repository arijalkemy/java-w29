package com.example.HQL.service;


import com.example.HQL.model.Vehiculo;
import com.example.HQL.model.VehiculoDTO;
import com.example.HQL.repository.VehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<String> getListPatents() {
        List<String> patents = vehiculoRepository.findPatente();

        return patents;
    }
}
