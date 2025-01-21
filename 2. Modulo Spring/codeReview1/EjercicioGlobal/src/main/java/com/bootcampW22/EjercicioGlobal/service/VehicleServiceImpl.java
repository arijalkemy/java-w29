package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ExistException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    //Listar vehiculos
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    //1-Añadir un vehiculo
    @Override
    public Optional<VehicleDto> saveVehicle(VehicleDto v) {
        Optional<Vehicle> vehiculoById = vehicleRepository.findById(v.getId());
        if (vehiculoById.isPresent()){
            throw new ExistException("Identificador del vehículo ya existente.");
        }else {
            ObjectMapper mapper = new ObjectMapper();
            Vehicle vehiclePorGuardar = mapper.convertValue(v, Vehicle.class);
            Vehicle vehicleGuardado = vehicleRepository.addVehicle(vehiclePorGuardar);
            return Optional.ofNullable(mapper.convertValue(vehicleGuardado, VehicleDto.class));
        }
    }

    //2-Buscar vehiculos por color y año

    @Override
    public List<VehicleDto> serchByColorAndYear(String color, int year) {
        List<Vehicle> vehiculosFiltrados = vehicleRepository.findByColorAndyear(color,year);
        if(vehiculosFiltrados.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }

        ObjectMapper mapper =new ObjectMapper();
        return vehiculosFiltrados
                .stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    //3-Buscar vehiculos por color y perido de años

    @Override
    public List<VehicleDto> serchByBrandAndRangeYear(String marca, int yearMin, int yearMax) {
        List<Vehicle> listVehicleFilter = vehicleRepository.findByBrandAndRangeYear(marca,yearMin,yearMax);
        if (listVehicleFilter.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return listVehicleFilter
                .stream()
                .map(v-> mapper.convertValue(v,VehicleDto.class))
                .toList();
    }

    //4-Calcular la velocidad promedio de una marca

    @Override
    public AverageSpeedDTO getAverageSpeedByBrand(String marca) {
        List<Vehicle> vehiclesByBrand = vehicleRepository.findByBrand(marca);
        Double prom;
        if(vehiclesByBrand.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }else{
            prom =
                    vehiclesByBrand
                    .stream()
                    .mapToDouble(v-> Double.parseDouble(v.getMax_speed()))
                    .average()
                    .orElse(0.00);
        }

        return new AverageSpeedDTO(prom,marca);
    }

    //5-Añadir multiple vehiculos

    @Override
    public List<VehicleDto> saveMultVehicles(List<VehicleDto> listVehicles) {
        for (VehicleDto listVehicle : listVehicles) {
            Optional<Vehicle> vehiculoById = vehicleRepository.findById(listVehicle.getId());
            if (vehiculoById.isPresent()){
                throw new ExistException("Algún vehículo tiene un identificador ya existente.");
            }
        }
        //defino un array para ir gaudardano todos los vehiculos generados
        List<VehicleDto> listVehiculosGuardados = new ArrayList<>();
        for (VehicleDto listVehicle : listVehicles) {
            ObjectMapper mapper = new ObjectMapper();
            //tranformo el vehiculodto de la lista a un vehiculo
            Vehicle vehiclePorGuardar = mapper.convertValue(listVehicle, Vehicle.class);
            //guardo el vehiculo tranformado y obtengo el vehiculo guardado
            Vehicle vehicleGuardado = vehicleRepository.addVehicle(vehiclePorGuardar);
            VehicleDto vdto = mapper.convertValue(vehicleGuardado,VehicleDto.class);
            listVehiculosGuardados.add(vdto);
        }

        return listVehiculosGuardados;
    }

    //6-Actualizar velocidad máxima de un vehículo

    @Override
    public VehicleDto updateVehicleSpeed(Long id, MaxSpeedDTO msDTO) {
        Vehicle vehiculoById = vehicleRepository.findById(id).orElseThrow(()->new NotFoundException("No se encontró el vehículo."));
        vehiculoById.setMax_speed(msDTO.getMax_speed());
        Vehicle vehiculomodif = vehicleRepository.update(vehiculoById);
        ObjectMapper mapper =new ObjectMapper();
        return mapper.convertValue(vehiculomodif,VehicleDto.class);

    }

    //7-Listar vehiculos por tipo de combustible

    @Override
    public List<VehicleDto> serchByFuelType(String comb) {
        List<Vehicle> listByFuel = vehicleRepository.findByFuelType(comb);
        if(listByFuel.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }
        ObjectMapper mapper =new ObjectMapper();
        return listByFuel
                .stream()
                .map(v-> mapper.convertValue(v,VehicleDto.class))
                .toList();
    }

    //8-Eliminar un vehículo
    @Override
    public void deletevehicle(Long id) {
        Vehicle vehiculoById = vehicleRepository.findById(id).orElse(null);
        if (vehiculoById==null){
            throw new NotFoundException("No se encontró el vehículo.");
        }else{
            vehicleRepository.deletevehicle(vehiculoById);
        }
    }

    //9-Buscar vehículos por tipo de transmisión

    @Override
    public List<VehicleDto> searchByTransmission(String t) {
        List<Vehicle> listByTrans = vehicleRepository.findByTrasmission(t);
        if(listByTrans.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return listByTrans
                .stream()
                .map(v-> mapper.convertValue(v,VehicleDto.class))
                .toList();
    }

    //10-Actualizar el tipo de combustible de un vehículo

    @Override
    public VehicleDto updateFuelType(Long id, FuelTypeDTO ftDTO) {
        Vehicle vehiculoById = vehicleRepository.findById(id).orElseThrow(()->new NotFoundException("No se encontró el vehículo."));
        vehiculoById.setFuel_type(ftDTO.getFuel_type());
        Vehicle vehiculoModif = vehicleRepository.update(vehiculoById);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(vehiculoModif,VehicleDto.class);
    }


    //11-Obtener la capacidad promedio de personas por marca
    @Override
    public AveragePassengersDTO getAveragePassengers(String marca) {
        List<Vehicle> listByBrand = vehicleRepository.findByBrand(marca);
        Double prom;
        if(listByBrand.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }else{
             prom = listByBrand
                    .stream()
                    .mapToInt(v-> v.getPassengers())
                    .average()
                    .orElse(0.0);

        }
        return new AveragePassengersDTO(prom,marca);
    }

    @Override
    public List<VehicleDto> serchVehiclesByDimensions(String lr,String wr) {
        // Convertir los parámetros de longitud y ancho en rangos
        String[] lengthParts = lr.split("-");
        double minHeight = Double.parseDouble(lengthParts[0]);
        double maxHeight = Double.parseDouble(lengthParts[1]);

        String[] widthParts = wr.split("-");
        double minWidth = Double.parseDouble(widthParts[0]);
        double maxWidth = Double.parseDouble(widthParts[1]);

        List<Vehicle> listByDimension = vehicleRepository.findByDimension(maxHeight,minHeight,maxWidth,minWidth);
        if(listByDimension.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return listByDimension
                .stream()
                .map(v-> mapper.convertValue(v,VehicleDto.class))
                .toList();
    }

    //13- Listar vehículos por rango de peso
    @Override
    public List<VehicleDto> serchVehiclesByWeight(String min,String max) {
        double minWeight = Double.parseDouble(min);
        double maxWeight = Double.parseDouble(max);

        List<Vehicle> listByWeight = vehicleRepository.findByRangeWeight(minWeight,maxWeight);
        if(listByWeight.isEmpty()){
            throw new NotFoundException(" No se encontraron vehículos en ese rango de peso.");
        }

        ObjectMapper mapper= new ObjectMapper();
        return listByWeight
                .stream()
                .map(v-> mapper.convertValue(v,VehicleDto.class))
                .toList();
    }
}
