package com.example.vehicles.utils;

import com.example.vehicles.dto.VehicleDTO;
import com.example.vehicles.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {

    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    VehicleDTO vehicleToVehicleDTO(Vehicle vehicle);
    VehicleDTO objectToVehicleDTO(Object vehicle);
}
