package com.org.meli.joyeria.service;

import com.org.meli.joyeria.dto.JoyaDTO;

import java.util.List;

public interface IJoyaService {
    JoyaDTO createJoya(JoyaDTO joyaDTO);
    List<JoyaDTO> getAllJoyas();
    JoyaDTO deleteJoya(Long id);
    JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO);
}