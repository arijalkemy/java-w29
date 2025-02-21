package com.example.showroom.service;

import com.example.showroom.model.dto.ClotheDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IClotheService {
    List<ClotheDTO> findAll();
    ClotheDTO findById(Long code);
    ClotheDTO save(ClotheDTO clotheDTO);
    ClotheDTO update(Long code, ClotheDTO clotheDTO);
    void delete(Long code);
    List<ClotheDTO> findAllBySize(String size);
    List<ClotheDTO> filterByContainingName(String name);
}
