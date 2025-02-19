package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.PrendaDto;

import java.util.List;

public interface IPrendaService {
    public List<PrendaDto> findAll();
    public PrendaDto save(PrendaDto prendaDto);
    public PrendaDto findById(Long codigo);
    public PrendaDto update(Long codigo, PrendaDto prendaDto);
    public Boolean delete(Long codigo);
    public List<PrendaDto> findByTalla(String talla);
    public List<PrendaDto> findByName(String nombre);

}
