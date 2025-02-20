package com.org.meli.vehiculoshql.repository;


import com.org.meli.vehiculoshql.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v.licensePlate FROM Vehicle v")
    List<String> findAllLicensePlates();

    @Query("SELECT v FROM Vehicle v ORDER BY v.yearOfManufacture")
    List<Vehicle> findAllVehiclesOrderedByYear();

    @Query("SELECT v FROM Vehicle v WHERE v.numberOfWheels > 4 AND v.yearOfManufacture = YEAR(CURRENT_DATE)")
    List<Vehicle> findVehiclesWithMoreThanFourWheelsCurrentYear();

    @Query("SELECT v FROM Vehicle v JOIN v.accidents a WHERE a.economicLoss > 10000")
    List<Vehicle> findVehiclesWithAccidentLossGreaterThan10000();

    @Query("SELECT v FROM Vehicle v JOIN v.accidents a WHERE a.economicLoss > 10000 GROUP BY v")
    List<Vehicle> findVehiclesWithAccidentLossGreaterThan10000WithTotalLoss();
}

//En el repositorio traer la entidad completa y construir los dtos en
//el servicio