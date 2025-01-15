package com.mercadolibre.javawave29.concesionaria_de_autos.respository;

import com.mercadolibre.javawave29.concesionaria_de_autos.model.Vehicle;

import java.util.List;

public interface IRepository {

    List<Vehicle> getVehicles();
    Vehicle getVehicleById(Integer id);
    Boolean addVehicle (Vehicle vehicle);
}
