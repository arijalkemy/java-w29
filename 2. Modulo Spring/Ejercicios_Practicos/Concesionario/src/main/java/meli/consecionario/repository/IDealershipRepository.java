package meli.consecionario.repository;

import meli.consecionario.entity.Vehicle;

import java.util.Collection;
import java.util.List;

public interface IDealershipRepository {

    List<Vehicle> findall();
    Vehicle addVehicle(Vehicle vehicle);
    List<Vehicle> filterDates(String since, String to);
    List<Vehicle> filterPrice(Integer since, Integer to);

    Vehicle findById(Integer id);
}
