package com.bootcamp.accidented_vehicles.service;

import com.bootcamp.accidented_vehicles.dto.SinisterRequestDto;
import com.bootcamp.accidented_vehicles.dto.SinisterResponseDto;
import com.bootcamp.accidented_vehicles.model.Sinister;
import com.bootcamp.accidented_vehicles.model.Vehicle;
import com.bootcamp.accidented_vehicles.repository.SinisterRepository;
import com.bootcamp.accidented_vehicles.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinisterService implements ISinisterService{
    private SinisterRepository sinisterRepo;
    private VehicleRepository vehicleRepo;
    private ModelMapper mapper;

    @Autowired
    public SinisterService(VehicleRepository vehicleRepo, SinisterRepository sinisterRepo) {
        this.vehicleRepo = vehicleRepo;
        this.sinisterRepo = sinisterRepo;
        this.mapper = new ModelMapper();
    }


    @Override
    public SinisterResponseDto saveSinister(SinisterRequestDto sinisterDto) {
        Vehicle vehicle = vehicleRepo.findById(sinisterDto.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found :("));
        Sinister sinister = mapper.map(sinisterDto, Sinister.class);
        sinister.setId(null);
        sinister.setVehicle(vehicle);
        sinisterRepo.save(sinister);
        return mapper.map(sinister, SinisterResponseDto.class);
    }

    @Override
    public List<SinisterResponseDto> findAllSinisters() {
        return sinisterRepo.findAll().stream().map(s -> mapper.map(s, SinisterResponseDto.class)).toList();
    }
}
