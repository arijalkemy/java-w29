package com.hqlvivo.hqlvivo.service;

import com.hqlvivo.hqlvivo.dto.PantentDto;
import com.hqlvivo.hqlvivo.dto.PatentBrandDto;
import com.hqlvivo.hqlvivo.dto.SiniestroDto;
import com.hqlvivo.hqlvivo.dto.TotalLostDto;
import com.hqlvivo.hqlvivo.entities.VehicleModel;

import java.util.List;

public interface IVehicleService {

    public List<String> getAllPatents();
    public List<PatentBrandDto> getPatentAndBrandsByYear();
    public List<PantentDto> getThisYearFourWheelers();
    public List<SiniestroDto> getByHighLost();
    public TotalLostDto getTotalHighLost();
}
