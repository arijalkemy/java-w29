package com.example.covid.services;

import com.example.covid.dto.SintomaDTO;

import java.util.List;

public interface ISintomaService {
    public SintomaDTO findSymptomByName(String sintoma);
    public List<SintomaDTO> findSymptom();

}
