package com.meli.Showroom.service;

import com.meli.Showroom.dto.PrendaDto;
import com.meli.Showroom.dto.VentaDto;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    VentaDto save(VentaDto ventaDto);
    List<VentaDto> searchAll();
    VentaDto searchByNumer(Integer numero);
    VentaDto modify(Integer numero, VentaDto ventaDto);
    VentaDto delete(Integer numero);
    List<VentaDto> searchByFecha(LocalDate fecha);
    List<PrendaDto> getPrendasByVentaNumero(Integer numero);
}
