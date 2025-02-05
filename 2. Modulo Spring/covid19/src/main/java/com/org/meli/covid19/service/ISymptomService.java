package com.org.meli.covid19.service;

import com.org.meli.covid19.dto.SymptomDto;

import java.util.List;

public interface ISymptomService {
    List<SymptomDto> listAll();
    List<SymptomDto> findSymptomsByName(String name);
}
