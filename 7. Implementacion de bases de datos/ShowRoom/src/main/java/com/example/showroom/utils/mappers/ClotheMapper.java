package com.example.showroom.utils.mappers;

import com.example.showroom.model.dto.ClotheDTO;
import com.example.showroom.model.entity.Clothe;

import java.util.List;

public class ClotheMapper {
    public static Clothe toClothe(ClotheDTO clotheDTO) {
        return Clothe.builder()
                .code(clotheDTO.getCode())
                .name(clotheDTO.getName())
                .type(clotheDTO.getType())
                .brand(clotheDTO.getBrand())
                .color(clotheDTO.getColor())
                .size(clotheDTO.getSize())
                .quantity(clotheDTO.getQuantity())
                .salePrice(clotheDTO.getSalePrice())
                .build();
    }

    public static ClotheDTO toClotheDTO(Clothe clothe) {
        return ClotheDTO.builder()
                .code(clothe.getCode())
                .name(clothe.getName())
                .type(clothe.getType())
                .brand(clothe.getBrand())
                .color(clothe.getColor())
                .size(clothe.getSize())
                .quantity(clothe.getQuantity())
                .salePrice(clothe.getSalePrice())
                .build();
    }

    public static List<ClotheDTO> toClotheDTOList(List<Clothe> clothes) {
        return clothes.stream().map(ClotheMapper::toClotheDTO).toList();
    }

    public static List<Clothe> toClotheList(List<ClotheDTO> clothes) {
        return clothes.stream().map(ClotheMapper::toClothe).toList();
    }
}
