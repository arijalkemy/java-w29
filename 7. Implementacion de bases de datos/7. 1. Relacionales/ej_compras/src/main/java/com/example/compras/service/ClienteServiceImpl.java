package com.example.compras.service;

import com.example.compras.dto.request.ClienteRequestDto;
import com.example.compras.dto.response.ClienteResponseDto;
import com.example.compras.repository.ClienteRepository;
import com.example.compras.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public List<ClienteResponseDto> getClientes() {
        return repository.findAll().stream().map(Mapper::toClienteResponseDto).toList();
    }

    @Override
    public void saveCliente(ClienteRequestDto cliente) {
        repository.save(Mapper.toCliente(cliente));
    }
}
