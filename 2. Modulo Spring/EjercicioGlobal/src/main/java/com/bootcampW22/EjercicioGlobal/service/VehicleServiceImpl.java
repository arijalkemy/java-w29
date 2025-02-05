package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
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

    @Override
    public List<Vehicle> SearchByColorYear(String color, Integer year){
        return vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getColor().equals(color) && (vehicle.getYear() == (year))).toList();
    };

    @Override
    public List<Vehicle> findByYearBrand(Integer startYear, Integer endYear, String brand){
      return vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getYear()<=startYear && vehicle.getYear()>=endYear && vehicle.getBrand().equals(brand)).toList();
    };

    @Override
    public Double averageSpeedBrand(String brand){
        Double vehiclesByBrandSpeed = vehicleRepository.findAll().stream().mapToInt(vehicle ->  Integer.parseInt(vehicle.getMax_speed()))
                .average()
                .orElse(0.0);
        return vehiclesByBrandSpeed;
    };

    public String saveVehicles(List<VehicleDto> vehicleDTOs){
        vehicleDTOs.forEach(vehicleDTO -> {
            vehicleRepository.saveVehicule(vehicleDTO);
        });
        return "Vehiculos guardados correctamente";
    }

    @Override
    public String updateSpeedVehicle(Integer newSpeed, Long id){
        Vehicle vehicle = Optional.ofNullable(vehicleRepository.findById(id)).orElse(null);
        if(vehicle != null){
            vehicle.setMax_speed((newSpeed.toString()));
        }
        return "Vehiculo actualizado correctamente";
    };

    @Override
    public List<Vehicle> findByFuelType(String fuelType){
        return vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getFuel_type().equals(fuelType)).collect(Collectors.toList());
    };

    @Override
    public String deleteById(Long id){
        vehicleRepository.deleteById(id);
        return "Vehiculo eliminado correctamente";
    };

    @Override
    public List<Vehicle> findByTransmission(String transmission){
        return vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getTransmission().equals(transmission)).collect(Collectors.toList());
    };

    @Override
    public String updateFuelType(String fuelType, Long id){
        Vehicle vehicle = Optional.ofNullable(vehicleRepository.findById(id)).orElse(null);
        if(vehicle != null){
            vehicle.setFuel_type((fuelType.toString()));
        }
        return "Vehiculo actualizado correctamente";
    };

    @Override
    public Double averageCapacity(String brand){
        return vehicleRepository.findAll().stream().mapToInt(vehicle -> vehicle.getPassengers()).average().orElse(0.0);
    };

    @Override
    public List<Vehicle> findByDimentions(Double minWidth, Double minHeight,Double MaxWidth, Double MaxHeight){
        return vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getHeight() <= (MaxHeight) && vehicle.getHeight() >= minHeight && vehicle.getWidth() <= (MaxWidth) && vehicle.getWidth() >= minWidth).collect(Collectors.toList());
    };

    @Override
    public List<Vehicle> findByWeigth(Double minWeight, Double MaxWeight){
        return vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getWeight()<=MaxWeight && vehicle.getWeight()>=minWeight).collect(Collectors.toList());
    };
}
