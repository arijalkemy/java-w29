package com.bootcamp.accidented_vehicles.service;

import com.bootcamp.accidented_vehicles.dto.VehicleDto;
import com.bootcamp.accidented_vehicles.dto.VehiclePatentAndModel;
import com.bootcamp.accidented_vehicles.dto.VehiclePatentBrandModelDto;
import com.bootcamp.accidented_vehicles.dto.VehiclePatentBrandModelWithTotalDto;

import java.util.List;

public interface IVehicleService {
    VehicleDto saveVehicle(VehicleDto vehicleDto);

    List<VehicleDto> findAllVehicles();

    List<String> findAllPatents();

    List<VehiclePatentAndModel> getAllPatentsAndBrand();

    List<String> getAllPatentsFromCurrentYearAndWheelsGreaterThan4();

    List<VehiclePatentBrandModelDto> getAllPatentBrandModelWithLossGreaterThan10000();

    VehiclePatentBrandModelWithTotalDto getAllPatentBrandModelWithLossGreaterThan10000AndTotalLoss();
}
