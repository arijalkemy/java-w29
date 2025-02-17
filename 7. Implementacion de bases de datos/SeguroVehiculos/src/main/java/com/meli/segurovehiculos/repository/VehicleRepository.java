package com.meli.segurovehiculos.repository;

import com.meli.segurovehiculos.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v.plate FROM Vehicle v")
    List<String> findAllLicensePlates();

    @Query("SELECT v.plate, v.brand from Vehicle v order by v.year")
    List<Object[]> findAllYears();

    @Query("SELECT v.plate, v.brand from Vehicle v where v.numberOfWheels > 4 and v.year = :year")
    List<Object[]> findAllYearsWithWheels(@Param("year") int year);
}
