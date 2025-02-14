package com.example.exerciseJoyeriaHibernate.service;

import com.example.exerciseJoyeriaHibernate.dto.JoyaNroIdentificatorioResponseDto;
import com.example.exerciseJoyeriaHibernate.dto.JoyaRequestDto;
import com.example.exerciseJoyeriaHibernate.dto.JoyaResponseDto;

import java.util.List;

public interface IJoyaService {
    JoyaNroIdentificatorioResponseDto addJoya(JoyaRequestDto joyaRequestDto);

    List<JoyaResponseDto> findAll();

    void delete(Long id);

    JoyaResponseDto postUpdateJoya(Long id, JoyaRequestDto joyaRequestDto);

    List<JoyaResponseDto> findJoyaIsVenta();
}
