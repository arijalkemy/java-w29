package com.example.apisalud.service;

import com.example.apisalud.model.dto.response.SymptomResponse;
import com.example.apisalud.model.entity.Symptom;
import com.example.apisalud.repository.SymptomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {
    private final SymptomRepository symptomRepository = new SymptomRepository();

    public List<Symptom> getAll() {
        return symptomRepository.getAll();
    }

    public SymptomResponse getByName(String name) {
        System.out.println(symptomRepository.getByName(name).getName());
        return SymptomResponse.builder().severity(symptomRepository.getByName(name).getSeverity()).build();
    }

}
