package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.Collection;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    //[US-0001] //[US-OOO5]
    boolean findById(Long id);
    void addVehicle(Vehicle vehicle);

    //[US-0002]
    List<Vehicle> getVehiclesByColorYear(String color, int year);

    //[US-0003]
    List<Vehicle> getVehiclesByCBrandByBeetweenYears(String brand, int startYear, int endYear);

    //[US-0004]
    List<Vehicle> findVehicleByBrand(String brand);

    //[US-0006]
    void updateMaxSpeedVehicle(Long id, String updateSpeed);

    //[US-0007]
    List<VehicleDto> searchByFuelType(String type);

    //[US-0012]
    List<Vehicle> findByDimensions(Double minlength, Double maxlength, Double minwidth, Double maxwidth);

}
