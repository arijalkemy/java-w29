package org.example.ej_compra.service;

import org.example.ej_compra.dto.ClienteDto;
import org.example.ej_compra.dto.ClienteResponseDto;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    ClienteDto saveCliente(ClienteDto clienteDto);

    List<ClienteResponseDto> getAllClientes();
}
