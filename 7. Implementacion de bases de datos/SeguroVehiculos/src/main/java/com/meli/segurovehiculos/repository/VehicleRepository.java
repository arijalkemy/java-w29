package com.meli.segurovehiculos.repository;

import com.meli.segurovehiculos.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v.plate FROM Vehicle v")
    List<Vehicle> findAllLicensePlates();

    @Query("SELECT v.plate, v.brand from Vehicle v order by v.year")
    List<Vehicle> findAllYears();

    @Query("SELECT v.plate, v.brand from Vehicle v where v.numberOfWheels > 4 and v.year = :year")
    List<Vehicle> findAllYearsWithWheels(@Param("year") int year);
}
