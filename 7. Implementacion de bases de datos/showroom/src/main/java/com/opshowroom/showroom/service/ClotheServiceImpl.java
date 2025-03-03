package com.opshowroom.showroom.service;

import com.opshowroom.showroom.domain.Clothe;
import com.opshowroom.showroom.dto.request.ClotheDTO;
import com.opshowroom.showroom.exception.ClotheNotFoundException;
import com.opshowroom.showroom.repository.IClotheRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClotheServiceImpl implements IClotheService{

    private final IClotheRepository cRepo;
    private final ModelMapper mp;

    @Autowired
    public ClotheServiceImpl(IClotheRepository cRepo) {
        this.cRepo = cRepo;
        this.mp = new ModelMapper();
    }

    @Override
    public List<ClotheDTO> getClothes() {
        List<Clothe> clotheList = cRepo.findAll();
        return clotheList.stream().map(clothe -> mp.map(clothe,ClotheDTO.class)).toList();
    }

    @Override
    public ClotheDTO getClothe(Long code) {
        Optional<Clothe> clothe = cRepo.findById(code);
        if (clothe.isEmpty()) {
            throw new ClotheNotFoundException(code);
        }
        return mp.map(clothe.get(),ClotheDTO.class);
    }

    @Override
    public List<ClotheDTO> getClothesBySize(String size) {
        List<Clothe> clotheList = cRepo.findBySize(size);
        return  clotheList.stream().map(clothe -> mp.map(clothe, ClotheDTO.class)).toList();
    }

    @Override
    public List<ClotheDTO> getClothesByWordInName(String word) {
        List<Clothe> clotheList = cRepo.findByName(word);
        return clotheList.stream().map(clothe -> mp.map(clothe,ClotheDTO.class)).toList();
    }

    @Override
    public Clothe createClothe(ClotheDTO clotheDto) {
        Clothe clothe = mp.map(clotheDto, Clothe.class);
        return cRepo.save(clothe);
    }

    @Override
    public ClotheDTO updateClothe(Long code, ClotheDTO clothe) {
        Optional<Clothe> clotheOptional = cRepo.findById(code);
        if (clotheOptional.isEmpty()) {
            return null;
        }
        Clothe clotheToUpdate = mp.map(clothe, Clothe.class);
        clotheToUpdate.setCode(code);
        cRepo.save(clotheToUpdate);
        return clothe;
    }

    @Override
    public ClotheDTO deleteClothe(Long code) {
        return null;
    }
}
