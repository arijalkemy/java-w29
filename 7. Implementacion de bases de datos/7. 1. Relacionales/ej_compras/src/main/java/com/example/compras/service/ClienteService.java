package com.example.compras.service;

import com.example.compras.dto.request.ClienteRequestDto;
import com.example.compras.dto.response.ClienteResponseDto;

import java.util.List;

public interface ClienteService {
    List<ClienteResponseDto> getClientes();

    void saveCliente(ClienteRequestDto cliente);
}
