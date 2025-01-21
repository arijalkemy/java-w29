package meli.consecionario.service;

import meli.consecionario.dto.request.RequestVehicleDto;
import meli.consecionario.dto.response.VehicleDto;
import meli.consecionario.entity.Vehicle;

import java.util.List;

public interface IDealershipService {
    meli.consecionario.dto.response.AddVehicleDto addVehicle(RequestVehicleDto vehicleDto);
    List<VehicleDto> listVehicle();
    List<VehicleDto> filterDates(String since, String to);
    List<VehicleDto> filterPrice(Integer since, Integer to);
    VehicleDto findById(Integer id);
}
