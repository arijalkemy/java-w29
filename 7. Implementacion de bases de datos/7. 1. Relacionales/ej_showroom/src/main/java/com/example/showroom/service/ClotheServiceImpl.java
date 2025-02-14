package com.example.showroom.service;

import com.example.showroom.dto.ClotheDto;
import com.example.showroom.exception.NotFoundException;
import com.example.showroom.model.Clothe;
import com.example.showroom.repository.ClotheRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClotheServiceImpl implements ClotheService {

    private final ClotheRepository clotheRepository;

    private final ModelMapper mapper;

    @Override
    public List<ClotheDto> getClothes(String name, String size) {
        List<Clothe> clothes;

        if (name != null) {
            clothes = clotheRepository.findByNameContaining(name);
        } else if (size != null) {
            clothes = clotheRepository.findBySize(size);
        } else {
            clothes = clotheRepository.findAll();
        }

        return clothes.stream()
                .map(c -> mapper.map(c, ClotheDto.class))
                .toList();
    }

    @Override
    public String createClothe(ClotheDto clotheDto) {
        Clothe clothe = clotheRepository.save(mapper.map(clotheDto, Clothe.class));
        return String.format("Clothe with code %d created", clothe.getCode());
    }

    @Override
    public ClotheDto getClotheByCode(Integer code) {
        Clothe clothe = getClotheIfExists(code);
        return mapper.map(clothe, ClotheDto.class);
    }

    @Override
    public ClotheDto updateClothe(Integer code, ClotheDto clotheDto) {
        Clothe clothe = getClotheIfExists(code);
        mapper.map(clotheDto, clothe);
        return mapper.map(clotheRepository.save(clothe), ClotheDto.class);
    }

    @Override
    public void deleteClothe(Integer code) {
        Clothe clothe = getClotheIfExists(code);
        clotheRepository.delete(clothe);
    }

    private Clothe getClotheIfExists(Integer code) {
        return clotheRepository.findById(code).orElseThrow(() -> new NotFoundException("Clothe not found"));
    }
}
