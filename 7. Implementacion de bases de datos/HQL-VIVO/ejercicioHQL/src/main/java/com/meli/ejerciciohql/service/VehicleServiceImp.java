package com.meli.ejerciciohql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ejerciciohql.model.DTO.VehicleDto;
import com.meli.ejerciciohql.model.DTO.VehicleDtoByPatente;
import com.meli.ejerciciohql.model.DTO.VehicleDtoByPatenteAnio;
import com.meli.ejerciciohql.model.Vehicle;
import com.meli.ejerciciohql.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImp implements IVehicleService{
    @Autowired
    IVehicleRepository vehicleRepository;
    @Override
    public List<VehicleDto> getVehicles() {
        List<Vehicle> lista = vehicleRepository.findAll();
        return lista.stream()
                .map(vehicle -> new VehicleDto(
                        vehicle.getPatente(),
                        vehicle.getMarca(),
                        vehicle.getModelo(),
                        vehicle.getFabricacionAnio(),
                        vehicle.getCantidadRuedas()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {

        vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {

        vehicleRepository.deleteById(id);
    }

    @Override
    public VehicleDto findVehicle(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        return new VehicleDto(vehicle.getPatente(),vehicle.getMarca(),vehicle.getModelo()
                ,vehicle.getFabricacionAnio(),vehicle.getCantidadRuedas());
    }

    @Override
    public List<VehicleDtoByPatente> getPatentes() {

        return vehicleRepository.getPatentes().stream()
                .map(vehicle -> new VehicleDtoByPatente(vehicle.getPatente()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDtoByPatenteAnio> getPatentesAnio() {

        return vehicleRepository.getPatentesAnio().stream()
                .map(vehicle -> new VehicleDtoByPatenteAnio(vehicle.getPatente(), vehicle.getFabricacionAnio()))
                .collect(Collectors.toList());
    }
}
