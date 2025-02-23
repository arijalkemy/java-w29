package com.example.showroom.service;

import com.example.showroom.model.dto.ClotheDTO;
import com.example.showroom.model.entity.Clothe;
import com.example.showroom.repository.IClotheRepository;
import com.example.showroom.utils.mappers.ClotheMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClotheServiceImpl implements IClotheService {

    @Autowired
    private IClotheRepository clotheRepository;

    @Override
    public List<ClotheDTO> findAll() {
        return ClotheMapper.toClotheDTOList(clotheRepository.findAll());
    }

    @Override
    public ClotheDTO findById(Long code) {
        return ClotheMapper.toClotheDTO(clotheRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Not found")));
    }

    @Override
    public ClotheDTO save(ClotheDTO clotheDTO) {
        Clothe clothe = ClotheMapper.toClothe(clotheDTO);
        return ClotheMapper.toClotheDTO(clotheRepository.save(clothe));
    }

    @Override
    public ClotheDTO update(Long code, ClotheDTO clotheDTO) {
        Clothe clothe = clotheRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Not found"));
        Long clotheCode = clothe.getCode();
        clothe = ClotheMapper.toClothe(clotheDTO);
        clothe.setCode(clotheCode);
        clotheRepository.save(clothe);

        return ClotheMapper.toClotheDTO(clothe);
    }

    @Override
    public void delete(Long code) {
        Optional<Clothe> clothe = clotheRepository.findById(code);
        clothe.ifPresent(clotheRepository::delete);
    }

    @Override
    public List<ClotheDTO> findAllBySize(String size) {
        return ClotheMapper.toClotheDTOList(clotheRepository.findAllBySize(size));
    }

    @Override
    public List<ClotheDTO> filterByContainingName(String name) {
        return ClotheMapper.toClotheDTOList(clotheRepository.findAllByNameContainingIgnoreCase(name));
    }
}
