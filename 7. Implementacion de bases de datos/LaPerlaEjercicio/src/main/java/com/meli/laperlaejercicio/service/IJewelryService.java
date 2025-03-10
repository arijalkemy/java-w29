package com.meli.laperlaejercicio.service;

import com.meli.laperlaejercicio.entity.Jewelry;

import java.util.List;
import java.util.Optional;

public interface IJewelryService {
    public String saveJewelry(Jewelry jewelry);
    public List<Jewelry> findJewelrys();
    public Optional<Jewelry> findJewelry(Long id);
    public String deleteJewelry(Long id);
    public String editJewelry(Long id_modificar, Jewelry jewelry_modif);
}
