package com.bootcamp.accidented_vehicles.repository;

import com.bootcamp.accidented_vehicles.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Query("SELECT v.patent FROM Vehicle v")
    List<String> findAllPatents();

    @Query("SELECT v FROM Vehicle v ORDER BY v.manufactureYear")
    List<Vehicle> findAllPatentsAndModelsSortedByYear();

    @Query("SELECT v.patent FROM Vehicle v WHERE v.numberOfWheels > 4 AND v.manufactureYear = year(now())")
    List<String> findAllPatentsOnCurrentYearAndNumberOfWheelsGreaterThan4();

    @Query("SELECT v FROM Vehicle v JOIN v.sinisters s WHERE s.economicLoss >= 10000")
    List<Vehicle> findBySinistersEcomicLossBiggerThan10000();

    @Query("SELECT SUM(s.economicLoss) FROM Vehicle v JOIN v.sinisters s WHERE s.economicLoss >= 10000")
    Double findTotalEconomicLossWithVehiclesBiggerThan10000();
}
