package com.org.meli.covid19.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.meli.covid19.dto.SymptomDto;
import com.org.meli.covid19.entity.Symptom;
import com.org.meli.covid19.exception.NotFoundException;
import com.org.meli.covid19.repository.ISymptomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomServiceImpl implements ISymptomService {

    private final ISymptomRepository sintomaRepository;

    public SymptomServiceImpl(ISymptomRepository sintomaRepository) {
        this.sintomaRepository = sintomaRepository;
    }

    @Override
    public List<SymptomDto> listAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Symptom> symptoms = sintomaRepository.findAll();
        if(symptoms.isEmpty()) {
            throw new NotFoundException("No se encontraron síntomas");
        }
        return symptoms.stream()
                .map(symptom -> mapper.convertValue(symptom, SymptomDto.class))
                .toList();
    }

    @Override
    public List<SymptomDto> findSymptomsByName(String name) {
        List<Symptom> symptoms = sintomaRepository.findByName(name);
        if(symptoms.isEmpty()) {
            throw new NotFoundException("No se encontraron síntomas con el nombre: " + name);
        }
        ObjectMapper mapper = new ObjectMapper();
        return symptoms.stream()
                .map(symptom -> mapper.convertValue(symptom, SymptomDto.class))
                .toList();
    }
}
