package com.bootcamp.ej_practicos_p2.service;

import com.bootcamp.ej_practicos_p2.dto.PlateRequestDTO;
import com.bootcamp.ej_practicos_p2.dto.PlateResponseDTO;
import com.bootcamp.ej_practicos_p2.model.Ingredient;
import com.bootcamp.ej_practicos_p2.model.Plate;
import com.bootcamp.ej_practicos_p2.repository.FileIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PlateService implements IPlateService {

    private final FileIngredientRepository fileIngredientRepository;

    @Autowired
    public PlateService(FileIngredientRepository fileIngredientRepository) {
        this.fileIngredientRepository = fileIngredientRepository;
    }

    @Override
    public PlateResponseDTO getPlateInfo(PlateRequestDTO plateRequestDTO) {
        List<Ingredient> ingredients = fileIngredientRepository.filterIngredientsByName(plateRequestDTO.getIngredients());

        Plate plate = new Plate(plateRequestDTO.getName(), plateRequestDTO.getWeight(), ingredients);
        Ingredient mostCaloricIngredient = calculateMaxCaloricIngredient(plate);
        Integer totalCalories = calculateTotalCalories(plate);

        PlateResponseDTO response = new PlateResponseDTO(plate);
        response.setTotalCalories(totalCalories);
        response.setMostCaloricIngredient(mostCaloricIngredient);

        return response;
    }

    private Ingredient calculateMaxCaloricIngredient(Plate plate) {
        return plate.getIngredients().stream().max(Comparator.comparing(Ingredient::getCalories)).orElse(null);
    }

    private Integer calculateTotalCalories(Plate plate) {
        // ???????? weight
        return (int) (plate.getIngredients().stream().mapToInt(Ingredient::getCalories).sum() * plate.getWeight());
    }
}
