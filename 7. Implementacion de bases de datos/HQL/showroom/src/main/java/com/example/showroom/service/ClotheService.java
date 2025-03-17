package com.example.showroom.service;

import com.example.showroom.dto.ClotheDto;
import com.example.showroom.model.Clothe;
import com.example.showroom.repository.IClotheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClotheService implements IClotheService{
    @Autowired
    IClotheRepository iClotheRepository;

    ModelMapper mm = new ModelMapper();

    @Override
    public void deleteClothe(Integer code) {

    }

    @Override
    public List<ClotheDto> getClothes(String name, String size) {
        List<Clothe> clothes;
        if(name != null)  {
            clothes = iClotheRepository.findByName(name);
        } else if (size != null) {
            clothes = iClotheRepository.findBySize(size);
        } else {
            clothes = iClotheRepository.findAll();
        }
        return clothes.stream().map(clothe -> mm.map(clothe, ClotheDto.class)).toList();
    }

    @Override
    public String createClothe(ClotheDto clotheDto) {
        Clothe clothe = mm.map(clotheDto, Clothe.class);
        iClotheRepository.save(clothe);
        return "Saved";
    }

    @Override
    public ClotheDto getClotheByCode(Integer code) {
        return iClotheRepository.findById(code)
                .map(c -> mm.map(c, ClotheDto.class))
                .orElse(null); // Manejo cuando no se encuentra el código
    }


    @Override
    public String updateClothe(Integer code, ClotheDto clotheDto) {
        if(iClotheRepository.findById(code).isPresent()){
            iClotheRepository.save(mm.map(clotheDto, Clothe.class));
        }
        return "udated";
    }
}
