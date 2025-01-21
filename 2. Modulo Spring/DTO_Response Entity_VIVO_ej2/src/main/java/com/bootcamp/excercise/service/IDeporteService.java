package com.bootcamp.excercise.service;

import com.bootcamp.excercise.dto.CustumerDTO;
import com.bootcamp.excercise.entity.DeporteEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDeporteService {
    List<DeporteEntity> getAllSports();
    ResponseEntity<String> getSportLevelByName(String nombre);
    List<CustumerDTO> getAllSportsPersons();
}
