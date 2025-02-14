package com.example.compras.utils;

import com.example.compras.dto.request.ClienteRequestDto;
import com.example.compras.dto.response.ClienteResponseDto;
import com.example.compras.dto.response.CompraResponseDto;
import com.example.compras.model.Cliente;
import com.example.compras.model.Compra;

import java.time.LocalDate;

public class Mapper {

    public static Cliente toCliente(ClienteRequestDto c) {
        return new Cliente(null, c.name());
    }

    public static Compra toCompra(Cliente cliente, LocalDate fecha, Double monto) {
        return new Compra(cliente, fecha, monto);
    }

    public static ClienteResponseDto toClienteResponseDto(Cliente c) {
        return new ClienteResponseDto(c.getId(), c.getName());
    }

    public static CompraResponseDto toCompraResponseDto(Compra c) {
        return new CompraResponseDto(toClienteResponseDto(c.getCliente()), c.getFecha(), c.getMontoTotal());
    }
}
