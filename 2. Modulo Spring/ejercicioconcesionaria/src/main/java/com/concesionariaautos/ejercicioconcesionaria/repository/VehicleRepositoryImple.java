package com.concesionariaautos.ejercicioconcesionaria.repository;

import com.concesionariaautos.ejercicioconcesionaria.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImple implements IVehicleRepository{

    private List<Vehicle> vehicleList = new ArrayList<>();

    public VehicleRepositoryImple() {
        try {
            loadDataBase();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        vehicleList = vehicles;
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicleList
                .stream()
                .filter(v-> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }

    @Override
    public List<Vehicle> findBySinceToDate(String since, String to) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate toDate = LocalDate.parse(to);

        return vehicleList
                .stream()
                .filter(v->
                    v.getManufacturingDate().isAfter(sinceDate.minusDays(1)) &&
                    v.getManufacturingDate().isBefore(toDate.plusDays(1))
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findBySinceToPrice(String since, String to) {
        double priceSince = Double.parseDouble(since);
        double priceTo = Double.parseDouble(to);

        return vehicleList
                .stream()
                .filter(v->
                        v.getPrice() >= priceSince && v.getPrice() <= priceTo
                )
                .toList();
    }
}
