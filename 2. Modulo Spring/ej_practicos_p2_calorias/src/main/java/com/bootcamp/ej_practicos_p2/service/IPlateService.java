package com.bootcamp.ej_practicos_p2.service;

import com.bootcamp.ej_practicos_p2.dto.PlateRequestDTO;
import com.bootcamp.ej_practicos_p2.dto.PlateResponseDTO;

public interface IPlateService {
    PlateResponseDTO getPlateInfo(PlateRequestDTO plateRequestDTO);
}
