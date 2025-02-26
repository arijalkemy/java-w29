package com.opshowroom.showroom.service;

import com.opshowroom.showroom.domain.Clothe;
import com.opshowroom.showroom.dto.ClotheCreatedDTO;
import com.opshowroom.showroom.dto.ClotheDTO;
import com.opshowroom.showroom.dto.MessageDTO;

import java.util.List;

public interface IClotheService {

        List<ClotheDTO> searchClothes();

        ClotheDTO searchByCode(Long code);
        ClotheCreatedDTO saveClothe(ClotheDTO clothe);
        ClotheDTO modifyClothe(Long code, ClotheDTO clothe);
        MessageDTO deleteClothe(Long code);
        List<ClotheDTO> searchClothesBySize(Integer size);
        List<ClotheDTO> searchClothesByWordInName(String word);


}

