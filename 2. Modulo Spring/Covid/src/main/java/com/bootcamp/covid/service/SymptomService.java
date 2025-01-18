package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.SymptomDTO;
import com.bootcamp.covid.model.Symptom;
import com.bootcamp.covid.repository.SymptomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SymptomService implements ISymptomService {

    private final SymptomRepository symptomRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<SymptomDTO> findAllSymptoms() {
        return symptomRepository
                .findAll()
                .stream()
                .map(s -> objectMapper.convertValue(s, SymptomDTO.class))
                .toList();
    }

    @Override
    public String getSymptomRisk(String name) {
        Optional<Symptom> symptom = symptomRepository.findByName(name);

        if (symptom.isPresent()) {
            return symptom.get().getRiskLevel().toString();
        }

        return "Symptom not found for name: " + name;

    }
}
