package meli.ejercicio.service;

import meli.ejercicio.interfaces.VehiculoProjection;
import meli.ejercicio.interfaces.VehiculoProjectionModelo;
import meli.ejercicio.interfaces.VehiculoProjectionPerdidaTotal;
import meli.ejercicio.model.Vehiculo;

import java.util.List;

public interface VehiculoService {
    List<Vehiculo> findAll();
    List<String> findAllPatentes();
    List<VehiculoProjection> findPatenteYMarcaOrdenadosPorAnioFabricacion();
    List<String> findPatentePorAnioYRuedas();
    List<VehiculoProjectionModelo> findMatriculaMarcaModeloPorPerdida();
    List<VehiculoProjectionPerdidaTotal> findMatriculaMarcaModeloPerdida();
}
