package com.hqlvivo.hqlvivo.service;

import com.hqlvivo.hqlvivo.dto.PantentDto;
import com.hqlvivo.hqlvivo.dto.PatentBrandDto;
import com.hqlvivo.hqlvivo.dto.SiniestroDto;
import com.hqlvivo.hqlvivo.dto.TotalLostDto;
import com.hqlvivo.hqlvivo.entities.VehicleModel;
import com.hqlvivo.hqlvivo.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService{
    
    @Autowired
    private IVehicleRepository vRepo;
    
    @Override
    public List<String> getAllPatents() {
        return vRepo.listAllPlates();
    }

    @Override
    public List<PatentBrandDto> getPatentAndBrandsByYear() {
        return List.of();
    }

    @Override
    public List<PantentDto> getThisYearFourWheelers() {
        return List.of();
    }

    @Override
    public List<SiniestroDto> getByHighLost() {
        return List.of();
    }

    @Override
    public TotalLostDto getTotalHighLost() {
        return null;
    }
}
