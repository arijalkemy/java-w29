package com.example.integrador.service;

import com.example.integrador.model.Clothes;
import com.example.integrador.repository.IClothesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {
    private final IClothesRepo clothesRepo;

    public ClothesService(IClothesRepo clothesRepo) {
        this.clothesRepo = clothesRepo;
    }

    public Clothes addClothes(Clothes c){
        return clothesRepo.save(c);
    }

    public List<Clothes> searchAllClothes(){
        return clothesRepo.findAll();
    }
    public Optional<Clothes> searchCloth(Long id){
        return clothesRepo.findById(id);
    }

    public void delete(Long id){
        clothesRepo.deleteById(id);
    }

    public List<Clothes> searchClothesBySize(String size){
        return clothesRepo.findClothesBySizeEqualsIgnoreCase(size);
    }

    public List<Clothes> searchClothesByName(String name){
        return clothesRepo.findClothesByNameLikeIgnoreCase(name);
    }


}
