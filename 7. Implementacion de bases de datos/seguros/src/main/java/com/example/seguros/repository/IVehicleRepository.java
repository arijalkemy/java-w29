package com.example.seguros.repository;

import com.example.seguros.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends CrudRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v")
    List<Vehicle> findPatentesRegistered();

    @Query("SELECT v FROM Vehicle v order by v.yearFabricated")
    List<Vehicle> findBrandAndPatentOrderByYearFabricated();

    @Query("SELECT v FROM Vehicle v where v.wheels > 4 and v.yearFabricated = YEAR(CURRENT_DATE) ")
    List<Vehicle> findPatentsAbove4WheelsCurrentYear();

    @Query("SELECT v FROM Vehicle v JOIN v.accidents s WHERE s.economicLoss > 10000")
    List<Vehicle> findVehicleWithLostAbove10000();
}
