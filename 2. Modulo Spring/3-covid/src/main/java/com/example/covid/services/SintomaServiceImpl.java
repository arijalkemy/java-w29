package com.example.covid.services;

import com.example.covid.dto.SintomaDTO;
import com.example.covid.repositories.ISintomaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaServiceImpl implements ISintomaService {
    private ISintomaRepository _sintomaRepository;
    public SintomaServiceImpl(ISintomaRepository sintomaRepository){
        this._sintomaRepository = sintomaRepository;
    }
    @Override
    public SintomaDTO findSymptomByName(String sintoma) {
        ObjectMapper mapper = new ObjectMapper();
        SintomaDTO sintomaEncontrado = new SintomaDTO(this._sintomaRepository.findSymptomByName(sintoma).get());
        return sintomaEncontrado;
    }

    @Override
    public List<SintomaDTO> findSymptom() {
        return this._sintomaRepository.findSymptom().stream()
                .map(SintomaDTO::new)
                .toList();
    }
}
