package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.Collection;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    void save(Vehicle newVehicle);

    List<VehicleDto> searchByColorAndYear(String color, int year);

    List<VehicleDto> searchByBrandAndDates(String brand, int startYear, int endYear);

    List<Vehicle> getByBrand(String brand);

    void updateVehicleSpeed(Long id, String speed);

    List<VehicleDto> searchByFuelType(String type);

    boolean findOnlyById(Long id);

    void removeVehicle(Long id);

    List<VehicleDto> searchByTransmissionType(String type);

    void updateVehicleFuel(Long id, String fuel);

    List<VehicleDto> searchByDimensions(Double minLengths, Double maxLengths, Double minWidth, Double maxWidth1);

    List<VehicleDto> searchByWeight(Double min, Double max);
}
