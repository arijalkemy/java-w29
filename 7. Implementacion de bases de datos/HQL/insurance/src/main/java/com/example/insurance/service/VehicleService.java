package com.example.insurance.service;

import com.example.insurance.IVehicleRepository;
import com.example.insurance.dto.VehicleDTO;
import com.example.insurance.model.Accident;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {
    private final IVehicleRepository repository;

    public VehicleService(IVehicleRepository vehiculoRepository){
        this.repository = vehiculoRepository;
    }

    public List<VehicleDTO> searchAllPatentsRegistered(){
        return this.repository.findPatentesRegistered()
                .stream()
                .map(v -> VehicleDTO.builder()
                        .patent(v.getPatent())
                        .build())
                .toList();
    }

    public List<VehicleDTO> searchAllPatentsAndBrandOrderByYear(){
        return this.repository.findBrandAndPatentOrderByYearFabricated()
                .stream()
                .map(v -> VehicleDTO.builder()
                        .patent(v.getPatent())
                        .brand(v.getBrand())
                        .build())
                .toList();
    }

    public List<VehicleDTO> searchPatentsAbove4WheelsCurrentYear() {

        return this.repository.findPatentsAbove4WheelsCurrentYear()
                .stream()
                .map(v -> VehicleDTO.builder()
                        .patent(v.getPatent())
                        .brand(v.getBrand())
                        .build())
                .toList();
    }

    public List<VehicleDTO> searchVehicleWithLostAbove10000() {
        return this.repository.findVehicleWithLostAbove10000()
                .stream()
                .map( vehiculo -> VehicleDTO.builder()
                        .patent(vehiculo.getPatent())
                        .brand(vehiculo.getBrand())
                        .model(vehiculo.getModel())
                        .build()
                )
                .toList();
    }

    public List<VehicleDTO> getVehicleWithLostAbove10000WithTotal() {
        return this.repository.findVehicleWithLostAbove10000()
                .stream()
                .map( vehiculo -> VehicleDTO.builder()
                        .patent(vehiculo.getPatent())
                        .brand(vehiculo.getBrand())
                        .model(vehiculo.getModel())
                        .totalLost(
                                Optional.ofNullable(vehiculo.getAccidents())
                                        .map(accidents -> accidents.stream()
                                                .mapToDouble(Accident::getEconomicLoss)
                                                .sum())
                                        .orElse(0.0))
                        .build()
                )
                .toList();
    }
}
