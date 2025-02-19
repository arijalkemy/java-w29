package com.meli.Showroom.service;

import com.meli.Showroom.dto.PrendaDto;

import java.util.List;

public interface IPrendaService {
    PrendaDto save(PrendaDto prendaDto);
    List<PrendaDto> searchAll(String nombre);
    List<PrendaDto> searchByTalla(String talla);
    List<PrendaDto> searchByNombre(String nombre);
    PrendaDto searchByCode(Integer code);
    PrendaDto modify(Integer code, PrendaDto prendaDto);
    PrendaDto delete(Integer code);
}
