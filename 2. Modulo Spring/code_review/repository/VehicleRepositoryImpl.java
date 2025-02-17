package org.example.code_review.repository;

import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.code_review.entity.Vehicle;
import org.example.code_review.exception.ExceptionController;
import org.example.code_review.exception.NotFoundException;
import org.example.code_review.exception.VehicleAlreadyExistsException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private final ExceptionController exceptionController;
    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl(ExceptionController exceptionController) throws IOException {
        loadDataBase();
        this.exceptionController = exceptionController;
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    private boolean existsVehicleById(Long id){
        return this.listOfVehicles.stream().anyMatch(vehicle -> vehicle.getId().equals(id));
    }
    @Override
    public Vehicle create(Vehicle v) {
        if(existsVehicleById(v.getId())){
            throw new VehicleAlreadyExistsException("The vehicle with id: "  + v.getId() + " already exists");
        }

        this.listOfVehicles.add(v);
        return v;
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, Integer year) {
        return this.listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year)
                .toList();
    }

    @Override
    public List<Vehicle> getByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear) {
        return this.listOfVehicles
                .stream()
                .filter(vehicle ->
                        vehicle.getBrand().equals(brand) &&
                        vehicle.getYear() >= startYear &&
                        vehicle.getYear() <= endYear
                )
                .toList();
    }

    @Override
    public Double getAverageSpeedByBrand(String brand) {
        return this.listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .mapToDouble(value -> Double.parseDouble(value.getMax_speed()))
                .average()
                .orElse(0.0);
    }

    @Override
    public List<Vehicle> createAll(List<Vehicle> vehicles) {
        List<Vehicle> inserted = new ArrayList<>();
        for(Vehicle v : vehicles){
            if(!this.existsVehicleById(v.getId())){
                this.listOfVehicles.add(v);
                inserted.add(v);
            }
        }
        return inserted;
    }

    @Override
    public boolean existsById(Long id) {
        return this.listOfVehicles.stream().anyMatch(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public Vehicle updateSpeed(Long id, Double newSpeed) {
        return this.listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .map(vehicle -> {
                    vehicle.setMax_speed(String.valueOf(newSpeed));
                    return vehicle;
                })
                .orElse(null);
    }
    @Override
    public void updateFuel(Long id, String newFuelType) {
        this.listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .map(vehicle -> {
                    vehicle.setFuel_type(newFuelType);
                    return vehicle;
                    });
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return this.listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .toList();
    }
    private boolean between(double target, double b, double c){
        return target > c && target < b;
    }
    @Override
    public List<Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth) {
        return this.listOfVehicles
                .stream()
                .filter(vehicle ->
                        between(vehicle.getHeight(), minHeight, maxHeight) &&
                                between(vehicle.getWidth(), minWidth, maxWidth) )
                .toList();
    }

    @Override
    public List<Vehicle> findVehiclesByFuelType(String fuelType) {
        return this.listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getFuel_type().equals(fuelType))
                .toList();
    }

    @Override
    public String deleteById(Long id) {
        boolean removed = this.listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
        if (removed)
            return "Deleted with id: " + id;

        throw new NotFoundException("No se encontró el vehículo a eliminar con id: " + id);
    }

    @Override
    public List<Vehicle> findVehiclesTransmission(String type) {
        return this.listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getTransmission().equals(type))
                .toList();
    }



    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        // objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<>(){});

        listOfVehicles = vehicles;
    }
}
