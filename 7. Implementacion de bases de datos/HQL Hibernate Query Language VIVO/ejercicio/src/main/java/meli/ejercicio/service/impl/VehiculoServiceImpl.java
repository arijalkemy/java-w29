package meli.ejercicio.service.impl;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.interfaces.VehiculoProjection;
import meli.ejercicio.interfaces.VehiculoProjectionModelo;
import meli.ejercicio.interfaces.VehiculoProjectionPerdidaTotal;
import meli.ejercicio.model.Vehiculo;
import meli.ejercicio.repository.SiniestroJpaRepository;
import meli.ejercicio.repository.VehiculoJpaRepository;
import meli.ejercicio.service.VehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoJpaRepository vehiculoJpaRepository;

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoJpaRepository.findAll();
    }

    @Override
    public List<String> findAllPatentes() {
        return vehiculoJpaRepository.findAllPatentes();
    }

    @Override
    public List<VehiculoProjection> findPatenteYMarcaOrdenadosPorAnioFabricacion() {
        return vehiculoJpaRepository.findPatenteAndMarca();
    }

    @Override
    public List<String> findPatentePorAnioYRuedas() {
        return vehiculoJpaRepository.findPatenteByYearAndRuedas();
    }

    @Override
    public List<VehiculoProjectionModelo> findMatriculaMarcaModeloPorPerdida() {
        return vehiculoJpaRepository.findMatriculaMarcaModeloByPerdida();
    }

    @Override
    public List<VehiculoProjectionPerdidaTotal> findMatriculaMarcaModeloPerdida() {
        return vehiculoJpaRepository.findMatriculaMarcaModeloPerdida();
    }
}
