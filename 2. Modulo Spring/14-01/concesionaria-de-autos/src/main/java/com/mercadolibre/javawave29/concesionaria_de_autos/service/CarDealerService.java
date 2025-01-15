package com.mercadolibre.javawave29.concesionaria_de_autos.service;

import com.mercadolibre.javawave29.concesionaria_de_autos.dto.ServiceVehicleDTO;
import com.mercadolibre.javawave29.concesionaria_de_autos.dto.VehicleDTO;
import com.mercadolibre.javawave29.concesionaria_de_autos.exceptions.AddVehicleException;
import com.mercadolibre.javawave29.concesionaria_de_autos.exceptions.VehicleNotFoundException;
import com.mercadolibre.javawave29.concesionaria_de_autos.mapper.VehicleMapper;
import com.mercadolibre.javawave29.concesionaria_de_autos.model.Vehicle;
import com.mercadolibre.javawave29.concesionaria_de_autos.respository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class CarDealerService implements IService {

    private final IRepository repository;

    @Autowired
    public CarDealerService (IRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<List<VehicleDTO>> getVehicles() {
        List<Vehicle> vehicles = repository.getVehicles();
        if (vehicles.isEmpty()) throw new VehicleNotFoundException("No hay vehiculos");
        List<VehicleDTO> vehiclesDTO = toDTO(vehicles);
        return ResponseEntity.ok(vehiclesDTO);
    }

    @Override
    public ResponseEntity<ServiceVehicleDTO> getVehicleById(Integer id) {
        Vehicle vehicle = repository.getVehicleById(id);
        if (vehicle == null) throw new VehicleNotFoundException("No se encontró un vehiculo con el id: " + id);
        ServiceVehicleDTO vehicleDTO = VehicleMapper.toVehicleServiceDTO(vehicle);
        return ResponseEntity.ok(vehicleDTO);
    }

    @Override
    public ResponseEntity<List<VehicleDTO>> getVehicleByDate(Integer since, Integer to) {
        List<Vehicle> vehicles = repository.getVehicles();
        if (vehicles.isEmpty()) throw new VehicleNotFoundException("No hay vehiculos");
        List<VehicleDTO> vehiclesDTO = toDTO(vehicles);

        if (since != null) vehiclesDTO = filterVehicles(vehiclesDTO, (v -> v.returnYear() >= since));
        if (to != null) vehiclesDTO = filterVehicles(vehiclesDTO, (v -> v.returnYear() <= to));
        if (vehiclesDTO.isEmpty()) throw new VehicleNotFoundException("No hay vehiculos registrados con los parametros ingresados");

        return ResponseEntity.ok(vehiclesDTO);
    }

    @Override
    public ResponseEntity<List<VehicleDTO>> getVehicleByPrice(Double since, Double to) {
        List<Vehicle> vehicles = repository.getVehicles();
        if (vehicles.isEmpty()) throw new VehicleNotFoundException("No hay vehiculos");
        List<VehicleDTO> vehiclesDTO = toDTO(vehicles);

        if (since != null) vehiclesDTO = filterVehicles(vehiclesDTO, (v-> v.getPrice() >= since));
        if (to != null) vehiclesDTO = filterVehicles(vehiclesDTO, (v-> v.getPrice() <= to));
        if (vehiclesDTO.isEmpty()) throw new VehicleNotFoundException("No hay vehiculos registrados con los parametros ingresados");

        return ResponseEntity.ok(vehiclesDTO);
    }

    @Override
    public ResponseEntity<ServiceVehicleDTO> addVehicle(ServiceVehicleDTO vehicleDTO) {
        List<String> errors = validateVehicle(vehicleDTO);
        if (!errors.isEmpty()) throw new AddVehicleException(errors) ;
        Vehicle vehicle = VehicleMapper.fromDTO(vehicleDTO);
        if(!repository.addVehicle(vehicle)) throw new VehicleNotFoundException("No se pudo agregar el vehiculo");
        return ResponseEntity.status(201).body(vehicleDTO);
    }

    private List<String> validateVehicle(ServiceVehicleDTO vehicleDTO) {
        List<String> errors = new ArrayList<>();
        if (checkStrings(vehicleDTO.getBrand())) errors.add("Falta brand");
        if (checkStrings(vehicleDTO.getModel())) errors.add("Falta model");
        if (checkStrings(vehicleDTO.getManufacturingDate())) errors.add("Falta manufacturingDate");
        if (checkNumbers(vehicleDTO.getNumberOfKilometers())) errors.add("Falta numberOfKilometers");
        if (checkNumbers(vehicleDTO.getDoors())) errors.add("Falta doors");
        if (checkNumbers(vehicleDTO.getPrice())) errors.add("Falta price");
        if (checkStrings(vehicleDTO.getCurrency())) errors.add("Falta currency");
        if (vehicleDTO.getServices() == null) errors.add("Falta services");
        if (checkNumbers(vehicleDTO.getCountOfOwners())) errors.add("Falta countOfOwners");

        return errors;
    }

    private boolean checkNumbers(Integer property) {
        return property == null || property <= 0;
    }

    private boolean checkNumbers(Double property) {
        return property == null || property <= 0;
    }

    private Boolean checkStrings (String property) {
        return property == null || property.trim().isEmpty();
    }

    private List<VehicleDTO> filterVehicles(List<VehicleDTO> vehicles, Predicate<VehicleDTO> predicate) {
        return vehicles
                .stream()
                .filter(predicate)
                .toList();
    }

    private List<VehicleDTO> toDTO(List<Vehicle> vehicles) {
        return vehicles
                .stream()
                .map(VehicleMapper::toDTO)
                .toList();
    }
}
