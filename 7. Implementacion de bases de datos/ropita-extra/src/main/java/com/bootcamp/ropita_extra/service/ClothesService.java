package com.bootcamp.ropita_extra.service;

import com.bootcamp.ropita_extra.dto.ClothesDto;
import com.bootcamp.ropita_extra.exception.ClothesNotFoundException;
import com.bootcamp.ropita_extra.model.Clothes;
import com.bootcamp.ropita_extra.repository.jpa.ClothesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService implements IClothesService{
    private final ClothesRepository repo;
    private final ModelMapper mapper;

    @Autowired
    public ClothesService(ClothesRepository repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }


    @Override
    public String addClothes(ClothesDto clothesDto) {
        Clothes clothes = mapper.map(clothesDto, Clothes.class);
        Clothes saved = repo.save(clothes);
        return saved.getCode();
    }

    @Override
    public List<ClothesDto> findAllClothes(String name) {
        if (name != null && !name.isEmpty()) return repo.findByNameContainingIgnoreCase(name).stream().map(c -> mapper.map(c, ClothesDto.class)).toList();
        return repo.findAll().stream().map(c -> mapper.map(c, ClothesDto.class)).toList();
    }

    @Override
    public ClothesDto findClothesByCode(String code) {
        return repo.findById(code).map(c -> mapper.map(c, ClothesDto.class)).orElseThrow(ClothesNotFoundException::new);
    }

    @Override
    public ClothesDto updateClothes(String code, ClothesDto clothesDto) {
        Clothes dbClothes = repo.findById(code).orElseThrow(ClothesNotFoundException::new);
        dbClothes.setName(clothesDto.getName());
        dbClothes.setType(clothesDto.getType());
        dbClothes.setBrand(clothesDto.getBrand());
        dbClothes.setColor(clothesDto.getColor());
        dbClothes.setSize(clothesDto.getSize());
        dbClothes.setAmount(clothesDto.getAmount());
        dbClothes.setPrice(clothesDto.getPrice());
        repo.save(dbClothes);
        return clothesDto;
    }

    @Override
    public void deleteClothesByCode(String code) {
        Clothes dbClothes = repo.findById(code).orElseThrow(ClothesNotFoundException::new);
        repo.delete(dbClothes);
    }
}
