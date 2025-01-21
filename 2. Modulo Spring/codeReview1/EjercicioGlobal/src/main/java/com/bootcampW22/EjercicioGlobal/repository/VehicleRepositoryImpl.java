package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }


    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }

    //1- Añadir un vehiculo

    @Override
    public Vehicle addVehicle(Vehicle v) {
        listOfVehicles.add(v);
        return v;
    }


    //buscar vehiculo por ID
    @Override
    public Optional<Vehicle> findById(Long id) {
        return listOfVehicles.stream().filter(v-> v.getId().equals(id)).findFirst();
    }



    //2-Buscar vehiculo por color y año
    @Override
    public List<Vehicle> findByColorAndyear(String color, int year) {
        return  listOfVehicles
                .stream()
                .filter(v -> v.getColor().equalsIgnoreCase(color)) // Usa equalsIgnoreCase para simplificar
                .filter(v -> v.getYear() == year)
                .toList();
    }

    //3-Buscar vehiculos por color y rango de años
    @Override
    public List<Vehicle> findByBrandAndRangeYear(String marca, int yearMin, int yearMax) {
        return listOfVehicles
                .stream()
                .filter(v->v.getBrand().equalsIgnoreCase(marca))
                .filter(v-> yearMin<= v.getYear() && v.getYear() <=yearMax )
                .toList();
    }


    //4- Consultar velocidad promedio por marca (en el repo solo busco vehiculos por marca)
    @Override
    public List<Vehicle> findByBrand(String marca) {
        return listOfVehicles.stream().filter(v-> v.getBrand().equalsIgnoreCase(marca)).toList();
    }




    //5-Añadir multiple vehiculos (lo hago por service usando el moto add del service)


    //6-Actualizar velocidad máxima de un vehículo
    //10-Actualizar el tipo de combustible de un vehículo
    //mtodo generico update
    @Override
    public Vehicle update(Vehicle v) {
        listOfVehicles.replaceAll(vehiculo-> vehiculo.getId().equals(v.getId()) ? vehiculo:v);
        return v ;
    }

    //7-Listar vehículos por tipo de combustible
    @Override
    public List<Vehicle> findByFuelType(String combustible) {
        return listOfVehicles
                .stream()
                .filter(v->v.getFuel_type().equalsIgnoreCase(combustible))
                .toList();
    }

    //8-Eliminar un vehículo
    @Override
    public void deletevehicle(Vehicle v) {
        listOfVehicles.remove(v);
    }


    //9-Buscar vehículos por tipo de transmisión
    @Override
    public List<Vehicle> findByTrasmission(String t) {
        return listOfVehicles
                .stream()
                .filter(v-> v.getTransmission().equalsIgnoreCase(t))
                .toList();
    }

    //12-Buscar vehiculos por diminsiones
    @Override
    public List<Vehicle> findByDimension(double maxHeight, double minHeight, double maxWidth, double minWidth) {
        return listOfVehicles
                .stream()
                .filter(v-> v.getHeight() >= minHeight && v.getHeight() <= maxHeight)
                .filter(v-> v.getWidth() >= minWidth && v.getWidth() <= maxWidth)
                .toList();
    }

    //13- Listar vehículos por rango de peso

    @Override
    public List<Vehicle> findByRangeWeight(double minWeight, double maxWeight) {
        return listOfVehicles
                .stream()
                .filter(v-> v.getWeight() >= minWeight && v.getWeight()<=maxWeight)
                .toList();
    }


}
