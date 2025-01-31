package com.thiagoschreck.local.ej_concensionaria_autos.repository;

import com.thiagoschreck.local.ej_concensionaria_autos.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    private final Map<Integer, Vehicle> vehicles;
    private int identity;

    public VehicleRepositoryImpl() {
        vehicles = new HashMap<>();
        identity = 0;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicle.setId(identity++);
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findById(int id) {
        return vehicles.get(id);
    }

    @Override
    public List<Vehicle> find() {
        return vehicles.values().stream().toList();
    }

    @Override
    public List<Vehicle> find(String fromDate, String toDate) {
        return find().stream()
                .filter(vehicle -> fromDate == null
                        || format(vehicle.getManufacturingDate()).isAfter(format(fromDate)))
                .filter(vehicle -> toDate == null
                        || format(vehicle.getManufacturingDate()).isBefore(format(toDate)))
                .toList();
    }

    private LocalDate format(String dateString) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, dateTimeFormatter);
    }
}
