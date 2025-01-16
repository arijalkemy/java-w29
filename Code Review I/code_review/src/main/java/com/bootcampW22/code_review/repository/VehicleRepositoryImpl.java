package com.bootcampW22.code_review.repository;

import com.bootcampW22.code_review.dto.VehicleDto;
import com.bootcampW22.code_review.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Optional<Vehicle> getById(Long id) {
        return listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    @Override
    public void addVehicle(Vehicle newVehicle) {
        listOfVehicles.add(newVehicle);
    }

    @Override
    public List<Vehicle> getByColorAndYear(String color, Integer year) {
        return applyFilter(filterBy(color, Vehicle::getColor), filterBy(year, Vehicle::getYear));
    }

    @Override
    public List<Vehicle> getByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear) {
        return applyFilter(filterBy(brand, Vehicle::getBrand),
                filterBetween(startYear, endYear, Vehicle::getYear));
    }

    @Override
    public List<Vehicle> getByWeight(double weightMin, double weightMax) {
        return applyFilter(filterBetween(weightMin, weightMax, Vehicle::getWeight));
    }

    @Override
    public List<Vehicle> getByDimensions(double minLength, double maxLength, double minWidth, double maxWidth) {
        return applyFilter(filterBetween(minLength, maxLength, Vehicle::getHeight),
                filterBetween(minWidth, maxWidth, Vehicle::getWidth));
    }

    @Override
    public void updateFuel(Vehicle vehicle, String newFuelType) {
        vehicle.setFuel_type(newFuelType);
    }

    @Override
    public Double getAverageCapacityByBrand(String brand) {
        return applyFilter(filterBy(brand, Vehicle::getBrand))
                .stream().mapToInt(Vehicle::getPassengers)
                .average().orElse(0);
    }

    // MÉTODOS AUXILIARES
    @SafeVarargs
    private List<Vehicle> applyFilter(Predicate<Vehicle> ... filters) {
        return listOfVehicles.stream()
                .filter(Stream.of(filters).reduce(v -> true, Predicate::and))
                .toList();
    }

    private Predicate<Vehicle> filterBy (Integer property, Function<Vehicle, Integer> getter) {
        return v -> Objects.equals(getter.apply(v), property);
    }

    private Predicate<Vehicle> filterBy (String property, Function<Vehicle, String> getter) {
        return v -> getter.apply(v).equalsIgnoreCase(property);
    }

    private <T extends Comparable<T>> Predicate<Vehicle> filterBetween(T min, T max, Function<Vehicle, T> getter) {
        return v -> getter.apply(v).compareTo(min) >= 0 && getter.apply(v).compareTo(max) <= 0;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles;

        file = ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles = objectMapper.readValue(file, new TypeReference<>(){});

        listOfVehicles = vehicles;
    }
}
