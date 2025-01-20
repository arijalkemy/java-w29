package org.melibootcamp.concesionario.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.melibootcamp.concesionario.dto.request.VehicleRequestDto;
import org.melibootcamp.concesionario.dto.response.VehicleResponseDTO;
import org.melibootcamp.concesionario.dto.response.VehicleResponseUsedDto;
import org.melibootcamp.concesionario.entity.Vehicle;
import org.melibootcamp.concesionario.exception.NotFoundException;
import org.melibootcamp.concesionario.repository.VehicleRepositoryImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements IVehicleService{

    private final VehicleRepositoryImpl vehicleRepository;
    private final ObjectMapper objectMapper;

    @Override
    public VehicleResponseDTO createVehicle(VehicleRequestDto vehicleRequestDto) {
        Vehicle vehicleCreated = vehicleRepository.saveVehicle(objectMapper.convertValue(vehicleRequestDto,Vehicle.class));
        return objectMapper.convertValue(vehicleCreated,VehicleResponseDTO.class);
    }

    @Override
    public List<VehicleResponseUsedDto> getAllVehicles() {
        return vehicleRepository
                .getAllVehicles()
                .stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleResponseUsedDto.class))
                .toList();
    }


    @Override
    public List<VehicleResponseUsedDto> getAllVehiclesByDate(LocalDate since, LocalDate to) {
        List<VehicleResponseUsedDto> vehicleResponseUsedDtos = vehicleRepository
                .getAllVehiclesByDate(since,to)
                .stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleResponseUsedDto.class))
                .toList();

        if (vehicleResponseUsedDtos.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos dentro las fechas especificadas");
        }
        return vehicleResponseUsedDtos;
    }

    @Override
    public List<VehicleResponseUsedDto> getAllVehiclesByPrices(Double since, Double to) {
        List<VehicleResponseUsedDto> vehicleResponseUsedDtos = vehicleRepository
                .getAllVehiclesByPrices(since,to)
                .stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleResponseUsedDto.class))
                .toList();

        if (vehicleResponseUsedDtos.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos dentro las fechas especificadas");
        }
        return vehicleResponseUsedDtos;
    }

    @Override
    public VehicleResponseDTO getVehicleById(Integer id) {
        Optional<Vehicle> vehicle = vehicleRepository.findVehicleById(id);
        if (vehicle.isEmpty()){
            throw new NotFoundException("No se encontro el Vehiculo");
        }
        return objectMapper.convertValue(vehicle,VehicleResponseDTO.class);
    }
}
