package org.melibootcamp.bonusej1.service;

import org.melibootcamp.bonusej1.dto.GarmentDto;
import org.melibootcamp.bonusej1.dto.MessageDto;
import org.melibootcamp.bonusej1.entity.Garment;

import java.util.List;

public interface IGarmentService {
     MessageDto saveGarment(GarmentDto garment);
     MessageDto updateGarment(GarmentDto garmentDto, Long id);
     MessageDto deleteGarmentById(Long id);
     List<GarmentDto> getAllGarments();
     GarmentDto getGarmentById(Long id);
     List<GarmentDto> getPrendasBySize(String size);
     List<GarmentDto> getPrendasByNameContainingIgnoreCase(String name);

}
