package com.mercadolibre.bootcamp.joyerialasperlas.service;

import com.mercadolibre.bootcamp.joyerialasperlas.dto.JoyaDto;
import com.mercadolibre.bootcamp.joyerialasperlas.dto.res.JoyaResponseDto;
import com.mercadolibre.bootcamp.joyerialasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    List<JoyaDto> getJoyas();
    JoyaDto update(Integer id, JoyaDto req);
    JoyaResponseDto saveJoya(JoyaDto j);
    void deleteJoya(Integer id);

}
