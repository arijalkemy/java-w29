package com.bootcamp.hql.repository;

import com.bootcamp.hql.enity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.licensePlate FROM Vehiculo v")
    public List<Long> findAllPlates();

    @Query("SELECT v.licensePlate, v.brand FROM Vehiculo v ORDER BY v.yearOfManufacture")
    public Map<Long, String> findLicensePlateAndBrand();

    @Query("SELECT v.licensePlate FROM Vehiculo v WHERE v.numberOfWheels > 4 AND v.yearOfManufacture = year(current_date)")
    public List<Long> findPlatesByVehicleWithMoreThanFourWheels();
}
