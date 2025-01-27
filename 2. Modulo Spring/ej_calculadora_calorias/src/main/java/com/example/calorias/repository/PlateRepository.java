package com.example.calorias.repository;

import com.example.calorias.model.Plate;

import java.util.Optional;

public interface PlateRepository {

    Optional<Plate> getPlateByName(String name);

}
