package com.mercadolibre.bootcamp.showroom.service;

import com.mercadolibre.bootcamp.showroom.dto.GarmentDTO;
import com.mercadolibre.bootcamp.showroom.dto.MessageDTO;

import java.util.List;

public interface IGarmentService {

    MessageDTO save(GarmentDTO garmentDTO);
    List<GarmentDTO> searchAll(String name, Integer size);
    GarmentDTO searchById(Long id);
    void updateById(Long id, GarmentDTO garmentDTO);
    MessageDTO deleteById(Long id);

}
