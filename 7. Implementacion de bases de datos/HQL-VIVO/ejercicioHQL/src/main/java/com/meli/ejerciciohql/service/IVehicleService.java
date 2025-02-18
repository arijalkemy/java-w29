package com.meli.ejerciciohql.service;

import com.meli.ejerciciohql.model.DTO.VehicleDto;
import com.meli.ejerciciohql.model.DTO.VehicleDtoByPatente;
import com.meli.ejerciciohql.model.DTO.VehicleDtoByPatenteAnio;
import com.meli.ejerciciohql.model.Vehicle;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehicleService {
    public List<VehicleDto> getVehicles();
    public void saveVehicle(Vehicle vehicle);
    public void deleteVehicle(Long id);
    public VehicleDto findVehicle (Long id);
    List<VehicleDtoByPatente> getPatentes();
    List<VehicleDtoByPatenteAnio> getPatentesAnio();

}
