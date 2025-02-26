package com.opshowroom.showroom.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opshowroom.showroom.domain.Clothe;
import com.opshowroom.showroom.dto.ClotheCreatedDTO;
import com.opshowroom.showroom.dto.ClotheDTO;

import com.opshowroom.showroom.dto.MessageDTO;
import com.opshowroom.showroom.repository.ClotheRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClotheServiceImpl implements IClotheService{

     private final ClotheRepository cRepo;

     private final ObjectMapper objMapper= new ObjectMapper();


    @Override
    @Transactional(readOnly = true)
    public List<ClotheDTO> searchClothes() {
        List<Clothe> clotheList = cRepo.findAll();
        System.out.println(clotheList);
        ObjectMapper om = new ObjectMapper();
        return clotheList.stream().map(clothe -> om.convertValue(clothe,ClotheDTO.class)).toList();
    }

    @Override
    public ClotheDTO searchByCode(Long code) {
        Optional<Clothe> clothe = cRepo.findById(code);
        if (clothe.isEmpty()){
            //TODO: throw exception
        }
        ObjectMapper om = new ObjectMapper();
        return om.convertValue(clothe.get(),ClotheDTO.class);
    }

    @Override
    public List<ClotheDTO> searchClothesBySize(Integer size) {
        List<Clothe> clotheList = cRepo.findBySize(size);
        return  clotheList.stream().map(clothe -> objMapper.convertValue(clothe, ClotheDTO.class)).toList();
    }

    @Override
    public List<ClotheDTO> searchClothesByWordInName(String word) {
        List<Clothe> clotheList = cRepo.findByKeyWord(word);
        System.out.println(word);
        System.out.println(clotheList);
        return clotheList.stream().map(clothe -> objMapper.convertValue(clothe,ClotheDTO.class)).toList();
    }

    @Override
    @Transactional()
    public ClotheCreatedDTO saveClothe(ClotheDTO clothe) {
        Clothe savedClothe = cRepo.save(objMapper.convertValue(clothe,Clothe.class));
        System.out.println(savedClothe);
        return new ClotheCreatedDTO(new MessageDTO("Clothe created successfully"),savedClothe.getCode());
    }

    @Override
    public ClotheDTO modifyClothe(Long code, ClotheDTO clothe) {
        Clothe updatedClothe = objMapper.convertValue(clothe,Clothe.class);
        updatedClothe.setCode(code);
        Clothe modified =cRepo.save(updatedClothe);
        return objMapper.convertValue(modified,ClotheDTO.class);
    }

    @Override
    public MessageDTO deleteClothe(Long code) {
        //TODO: add validation of code not null and if exist
        cRepo.deleteById(code);
        return new MessageDTO("Delete successfully");
    }
}
