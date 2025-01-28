package com.example.calorias.service;

import com.example.calorias.dtos.PlateRequestDto;
import com.example.calorias.dtos.PlateResponseDto;
import com.example.calorias.exceptions.NotFoundException;
import com.example.calorias.model.Ingredient;
import com.example.calorias.model.Plate;
import com.example.calorias.repository.PlateRepository;
import com.example.calorias.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlateServiceImpl implements PlateService {

    private final PlateRepository repo;

    @Override
    public PlateResponseDto getPlateInfo(PlateRequestDto plateRequestDTO) {
        Plate plate = repo.findPlateByName(plateRequestDTO.name())
                .orElseThrow(() -> new NotFoundException("No se encontró el plato"));

        plate.setWeight(plateRequestDTO.weight());

        Ingredient mostCaloricIngredient = calculateMaxCaloricIngredient(plate);
        Integer totalCalories = calculateTotalCalories(plate);

        return Mapper.createPlateResponse(plate, totalCalories, mostCaloricIngredient);
    }

    @Override
    public List<PlateResponseDto> getBatchPlateInfo(List<PlateRequestDto> plateRequestDTOs) {
        List<PlateResponseDto> responses = new ArrayList<>();
        plateRequestDTOs.forEach(p -> responses.add(getPlateInfo(p)));
        return responses;
    }

    private Ingredient calculateMaxCaloricIngredient(Plate plate) {
        return plate.getIngredients().stream().max(Comparator.comparing(Ingredient::getCalories)).orElse(null);
    }

    private Integer calculateTotalCalories(Plate plate) {
        return (int) (plate.getIngredients().stream().mapToInt(Ingredient::getCalories).sum() * plate.getWeight() / 100);
    }
}
