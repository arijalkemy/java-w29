package com.example.showroom.service;

import com.example.showroom.dto.request.ClotheRequestDto;
import com.example.showroom.dto.response.ClotheResponseDto;
import com.example.showroom.entity.Clothe;
import com.example.showroom.repository.IClotheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClotheServiceImpl implements IClotheService{
    private final IClotheRepository clotheRepository;

    final ModelMapper mp = new ModelMapper();

    public ClotheServiceImpl(IClotheRepository clotheRepository) {
        this.clotheRepository = clotheRepository;
    }

    @Override
    public ClotheResponseDto save(ClotheRequestDto clotheRequestDto) {
        Clothe clothe = mp.map(clotheRequestDto, Clothe.class);
        return mp.map(clotheRepository.save(clothe), ClotheResponseDto.class);
    }

    @Override
    public List<ClotheResponseDto> searchClothes() {
        List<Clothe> clotheList =  clotheRepository.findAll();
        return clotheList.stream().map(this::convertEntityToDto).toList();
    }

    @Override
    public ClotheResponseDto searchClotheByCode() {
        return null;
    }

    @Override
    public ClotheResponseDto modifyClotheByCode() {
        return null;
    }

    private ClotheResponseDto convertEntityToDto(Clothe clothe){
        return ClotheResponseDto.builder()
                .id(clothe.getId())
                .code(clothe.getCode())
                .name(clothe.getName())
                .type(clothe.getType())
                .brand(clothe.getBrand())
                .color(clothe.getColor())
                .size(clothe.getSize())
                .quantity(clothe.getQuantity())
                .priceSale(clothe.getPriceSale())
                .build();
    }
}
