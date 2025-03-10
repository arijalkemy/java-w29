package org.example.ej_joyeria.service;

import org.example.ej_joyeria.model.Jewelry;

import java.util.List;

public interface IJewelryService  {

    List<Jewelry> getJewelry();
    void addJewelry(Jewelry jewelry);
    void deleteJewelry(Long id);
    void updateJewelry(Long id, Jewelry jewelry);
}
