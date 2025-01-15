package com.mercadolibre.javawave29.concesionaria_de_autos.service;

import com.mercadolibre.javawave29.concesionaria_de_autos.dto.ServiceVehicleDTO;
import com.mercadolibre.javawave29.concesionaria_de_autos.dto.VehicleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IService {
    ResponseEntity<List<VehicleDTO>> getVehicles ();
    ResponseEntity<ServiceVehicleDTO> getVehicleById (Integer id);
    ResponseEntity<ServiceVehicleDTO> addVehicle (ServiceVehicleDTO vehicleDTO);
    ResponseEntity<List<VehicleDTO>> getVehicleByDate(Integer since, Integer to);
    ResponseEntity<List<VehicleDTO>> getVehicleByPrice(Double since, Double to);
}
