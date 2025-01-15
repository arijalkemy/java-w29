package com.mercadolibre.javawave29.concesionaria_de_autos.mapper;

import com.mercadolibre.javawave29.concesionaria_de_autos.dto.ServiceVehicleDTO;
import com.mercadolibre.javawave29.concesionaria_de_autos.dto.VehicleDTO;
import com.mercadolibre.javawave29.concesionaria_de_autos.model.Vehicle;

public class VehicleMapper {

    public static VehicleDTO toDTO (Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDTO.setDoors(vehicle.getDoors());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setCountOfOwners(vehicle.getCountOfOwners());
        return vehicleDTO;
    }

    public static ServiceVehicleDTO toVehicleServiceDTO (Vehicle vehicle) {
        ServiceVehicleDTO vehicleDTO = new ServiceVehicleDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDTO.setDoors(vehicle.getDoors());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setCountOfOwners(vehicle.getCountOfOwners());
        vehicleDTO.setServices(vehicle.getServices());
        return vehicleDTO;
    }

    public static Vehicle fromDTO (ServiceVehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setManufacturingDate(vehicleDTO.getManufacturingDate());
        vehicle.setNumberOfKilometers(vehicleDTO.getNumberOfKilometers());
        vehicle.setDoors(vehicleDTO.getDoors());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setCurrency(vehicleDTO.getCurrency());
        vehicle.setServices(vehicleDTO.getServices());
        vehicle.setCountOfOwners(vehicleDTO.getCountOfOwners());
        return vehicle;
    }
}
