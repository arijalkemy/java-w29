package org.example.ej_compra.service;

import org.example.ej_compra.dto.CompraDto;
import org.example.ej_compra.model.Cliente;

import java.util.List;

public interface ICompraService {

    List<CompraDto> getAllCompras();

    CompraDto saveCompra(Long clienteId, CompraDto compraDto);
}
