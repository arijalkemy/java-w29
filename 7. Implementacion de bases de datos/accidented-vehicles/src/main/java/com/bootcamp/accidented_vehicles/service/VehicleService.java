package com.bootcamp.accidented_vehicles.service;

import com.bootcamp.accidented_vehicles.dto.VehicleDto;
import com.bootcamp.accidented_vehicles.dto.VehiclePatentBrandModelDto;
import com.bootcamp.accidented_vehicles.dto.VehiclePatentBrandModelWithTotalDto;
import com.bootcamp.accidented_vehicles.model.Vehicle;
import com.bootcamp.accidented_vehicles.dto.VehiclePatentAndModel;
import com.bootcamp.accidented_vehicles.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService{
    private VehicleRepository repo;
    private ModelMapper mapper;

    @Autowired
    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = mapper.map(vehicleDto, Vehicle.class);
        repo.save(vehicle);
        return vehicleDto;
    }

    @Override
    public List<VehicleDto> findAllVehicles() {
        return repo.findAll().stream().map(v -> mapper.map(v, VehicleDto.class)).toList();
    }

    @Override
    public List<String> findAllPatents() {
        return repo.findAllPatents();
    }

    @Override
    public List<VehiclePatentAndModel> getAllPatentsAndBrand() {
        return repo.findAllPatentsAndModelsSortedByYear().stream().map(v -> mapper.map(v, VehiclePatentAndModel.class)).toList();
    }

    @Override
    public List<String> getAllPatentsFromCurrentYearAndWheelsGreaterThan4() {
        return repo.findAllPatentsOnCurrentYearAndNumberOfWheelsGreaterThan4();
    }

    @Override
    public List<VehiclePatentBrandModelDto> getAllPatentBrandModelWithLossGreaterThan10000() {
        return repo.findBySinistersEcomicLossBiggerThan10000().stream().map(v -> mapper.map(v, VehiclePatentBrandModelDto.class)).toList();
    }

    @Override
    public VehiclePatentBrandModelWithTotalDto getAllPatentBrandModelWithLossGreaterThan10000AndTotalLoss() {
        List<VehiclePatentBrandModelDto> patentBrandModel = getAllPatentBrandModelWithLossGreaterThan10000();
        Double totalLoss = repo.findTotalEconomicLossWithVehiclesBiggerThan10000();
        VehiclePatentBrandModelWithTotalDto response = new VehiclePatentBrandModelWithTotalDto();
        response.setPatentBrandModel(patentBrandModel);
        response.setTotal(totalLoss);
        return response;
    }
}
