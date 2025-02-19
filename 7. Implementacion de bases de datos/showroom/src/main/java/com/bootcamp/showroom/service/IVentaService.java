package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.VentaDto;

import java.util.List;

public interface IVentaService {
    VentaDto save(VentaDto ventaDto);
    VentaDto findById(Long id);
    List<VentaDto> findAll();
    VentaDto update(Long numero, VentaDto ventaDto);
    Boolean delete(Long id);
}
