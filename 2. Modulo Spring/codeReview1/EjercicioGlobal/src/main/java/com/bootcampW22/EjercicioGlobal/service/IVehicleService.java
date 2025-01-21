package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    //1- Añadir un vehiculo
    Optional<VehicleDto> saveVehicle(VehicleDto v);

    //2-Buscar vehiculos por año y color
    List<VehicleDto> serchByColorAndYear(String color, int year);

    //3-Buscar vehiculos por MARCA y rango de años
    List<VehicleDto> serchByBrandAndRangeYear(String marca, int yearMin , int yearMax);

    //4-Consultar velocidad promedio por marca
    AverageSpeedDTO getAverageSpeedByBrand(String marca);

    //5-Añadir multiple vehiculos
    List<VehicleDto> saveMultVehicles(List<VehicleDto> listVehicles);

    //6-Actualizar velocidad máxima de un vehículo
    VehicleDto updateVehicleSpeed(Long id , MaxSpeedDTO msDTO);

    //7-Listar vehículos por tipo de combustible
    List<VehicleDto> serchByFuelType(String comb);

    //8-Eliminar un vehículo
    void deletevehicle(Long id);

    //9-Buscar vehículos por tipo de transmisión
    List<VehicleDto> searchByTransmission(String t);

    //10-Actualizar el tipo de combustible de un vehículo

    VehicleDto updateFuelType(Long id, FuelTypeDTO ftDTO);

    //11- Obtener la capacidad promedio de personas por marca
    AveragePassengersDTO getAveragePassengers(String marca);

    //12-Buscar vehiculos por dimensiones
    List<VehicleDto> serchVehiclesByDimensions (String lengthRange , String widthRange);

    //13-Listar vehículos por rango de peso
    List<VehicleDto> serchVehiclesByWeight(String minw, String maxw);
}
