package com.example.jewelry.service;

import com.example.jewelry.model.Jewelry;

import java.util.List;

public interface JewelryService {
    List<Jewelry> getJewelry();

    void updateJewelry(Long id, Jewelry jewelry);

    void saveJewelry(Jewelry Jewelry);

    void deleteJewelry(Long id);

    Jewelry findJewelry(Long id);
}
