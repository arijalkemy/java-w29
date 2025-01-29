package prj.concesionaria.repository;

import prj.concesionaria.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehiclesRepository implements IVehiclesRepository{
    private List<Vehicle> vehicleList;

    public VehiclesRepository() {
        this.vehicleList = new ArrayList<>();
    }

    @Override
    public List<Vehicle> save(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return vehicleList;
    }

    @Override
    public List<Vehicle> allVehicles() {
        return vehicleList;
    }

    @Override
    public List<Vehicle> vehiclesByYears(Integer since, Integer to) {
        return vehicleList.stream().filter(v-> v.getManufacturingDate()>= since && v.getManufacturingDate()<=to).toList();
    }

    @Override
    public List<Vehicle> vehiclesByPrice(Integer since, Integer to) {
        return vehicleList.stream().filter(v-> v.getPrice()>= since && v.getPrice()<=to).toList();
    }

    @Override
    public Vehicle findById(Integer id) {
        return vehicleList.stream().filter(v -> v.getVehicleId().equals(id)).findFirst().get();
    }

}
