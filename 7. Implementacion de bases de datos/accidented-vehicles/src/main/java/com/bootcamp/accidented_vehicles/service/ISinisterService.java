package com.bootcamp.accidented_vehicles.service;

import com.bootcamp.accidented_vehicles.dto.SinisterRequestDto;
import com.bootcamp.accidented_vehicles.dto.SinisterResponseDto;

import java.util.List;

public interface ISinisterService {
    SinisterResponseDto saveSinister(SinisterRequestDto sinisterDto);

    List<SinisterResponseDto> findAllSinisters();
}
