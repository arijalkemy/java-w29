package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    //1- Añadir un vehiculo
    Vehicle addVehicle(Vehicle v);
    //busca vehiculo por ID
    Optional<Vehicle> findById(Long id);

    //2-Buscar vehiculo por color y año
    List<Vehicle> findByColorAndyear (String color , int year);

    //3- Buscar vehiculo por marca y rango de años
    List<Vehicle> findByBrandAndRangeYear(String marca, int yearMin, int yearMax);

    //4- Consultar velocidad promedio por marca (en el repo solo busco vehiculos por marca)
    //11- Obtener la capacidad promedio de personas por marca (en el repo solo busco vehiculos por marca)
    List<Vehicle> findByBrand(String marca);

    //5-Añadir multiple vehiculos (lo hago por service usando el moto add del service)

    //6-Actualizar velocidad máxima de un vehículo
    //10-Actualizar el tipo de combustible de un vehículo
    //Metodo update generico para todos los update

    Vehicle update(Vehicle v);

    //7-Listar vehículos por tipo de combustible
    List<Vehicle> findByFuelType(String combustible);

    //8-Eliminar un vehículo
    public void deletevehicle(Vehicle v);

    //9-Buscar vehículos por tipo de transmisión
    List<Vehicle> findByTrasmission(String t);

    //12-Buscar vehiculos por dimensiones
    List<Vehicle> findByDimension(double maxHeight, double minHeight, double maxWidth, double minWidth);

    //13-Buscar vehiculos por rango de peso
    List<Vehicle> findByRangeWeight(double minWeight, double maxWeight);



}
