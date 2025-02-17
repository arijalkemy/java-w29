package hql.hqlmovies.service;

import hql.hqlmovies.dto.VehicleDTO;
import hql.hqlmovies.model.Siniestro;
import hql.hqlmovies.repository.IVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleServiceImpl {

    private final IVehicleRepository repository;

    public VehicleServiceImpl(IVehicleRepository repository) {
        this.repository = repository;
    }

    public List<VehicleDTO> searchAllPatentsRegistered(){
        return this.repository.findPatentesRegistered()
                .stream()
                .map(vehiculo -> VehicleDTO.builder()
                        .patent(vehiculo.getPatent())
                        .build())
                .toList();
    }

    public List<VehicleDTO> searchAllPatentsAndBrandOrderByYear(){
        return this.repository.findBrandAndPatentOrderByYearFabricated()
                .stream()
                .map( vehiculo -> VehicleDTO.builder()
                        .patent(vehiculo.getPatent())
                        .brand(vehiculo.getBrand())
                        .build()
                )
                .toList();
    }

    public List<VehicleDTO> searchPatentsAbove4WheelsCurrentYear() {

        return this.repository.findPatentsAbove4WheelsCurrentYear()
                .stream()
                .map( vehiculo -> VehicleDTO.builder()
                        .patent(vehiculo.getPatent())
                        .build()
                )
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
                                Optional.ofNullable(vehiculo.getSiniestros())
                                        .map(siniestros -> siniestros.stream()
                                        .mapToDouble(Siniestro::getPerdidaEconomica)
                                        .sum())
                                .orElse(0.0))
                        .build()
                )
                .toList();
    }
}
