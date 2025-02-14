package com.example.compras.service;

import com.example.compras.dto.request.CompraRequestDto;
import com.example.compras.dto.response.CompraResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface CompraService {
    List<CompraResponseDto> getCompras();

    void saveCompra(Long clienteId, CompraRequestDto compra);

    CompraResponseDto getCompra(Long clienteId, LocalDate fecha);
}
