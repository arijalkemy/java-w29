package com.bootcampw29.jewelry.service;

import com.bootcampw29.jewelry.dto.request.JewelRequestDTO;
import com.bootcampw29.jewelry.dto.response.JewelCreatedDTO;
import com.bootcampw29.jewelry.dto.response.JewelResponseDTO;

import java.util.List;

public interface JewelService {
    JewelCreatedDTO createJewel(JewelRequestDTO jewelRequestDTO);
    JewelResponseDTO updateJewel(JewelRequestDTO jewelRequestDTO, Long id);
    List<JewelResponseDTO> findSaleJewels();
    void deleteJewel(Long id);

}
