package meli.consecionario.repository;

import meli.consecionario.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Repository
public class DealershipRepositoryImpl implements IDealershipRepository {

    List<Vehicle> listOfVehicle = new ArrayList<>();

    public DealershipRepositoryImpl(List<Vehicle> listOfVehicle){
        this.listOfVehicle =listOfVehicle;
    }

    @Override
    public List<Vehicle> findall() {
        return listOfVehicle;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicle.setId(listOfVehicle.size() + 1);
        listOfVehicle.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> filterDates(String since, String to) {
        return listOfVehicle
                .stream()
                .filter(vehicle -> LocalDate.parse(vehicle.getManufacturingDate()).isBefore(LocalDate.parse(to))
                && LocalDate.parse(vehicle.getManufacturingDate()).isAfter(LocalDate.parse(since)))
                .toList();

    }

    @Override
    public List<Vehicle> filterPrice(Integer since, Integer to) {
        return listOfVehicle
                .stream()
                .filter(vehicle -> Integer.parseInt(vehicle.getPrice()) >= since
                && Integer.parseInt(vehicle.getPrice()) <= to)
                .toList();
    }

    @Override
    public Vehicle findById(Integer id) {
        return listOfVehicle.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().orElse(null);
    }


}
