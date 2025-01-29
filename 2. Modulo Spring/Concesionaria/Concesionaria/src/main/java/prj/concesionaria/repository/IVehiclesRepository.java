package prj.concesionaria.repository;

import org.springframework.stereotype.Repository;
import prj.concesionaria.model.Vehicle;

import java.util.Arrays;
import java.util.List;
@Repository
public interface IVehiclesRepository {
    List<Vehicle> save(Vehicle vehicle);
    List<Vehicle> allVehicles();
    List<Vehicle> vehiclesByYears(Integer since, Integer to);
    List<Vehicle> vehiclesByPrice(Integer since, Integer to);
    Vehicle findById(Integer id);
}
