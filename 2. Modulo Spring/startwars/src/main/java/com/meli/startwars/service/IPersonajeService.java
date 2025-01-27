package com.meli.startwars.service;

import com.meli.startwars.dto.PersonajeDtoResponse;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDtoResponse> searchPersonajeByName(String name) throws Exception;
}
