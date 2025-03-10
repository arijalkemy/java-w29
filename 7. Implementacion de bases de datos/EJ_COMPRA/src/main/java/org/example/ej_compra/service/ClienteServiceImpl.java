package org.example.ej_compra.service;

import lombok.RequiredArgsConstructor;
import org.example.ej_compra.dto.ClienteDto;
import org.example.ej_compra.dto.ClienteResponseDto;
import org.example.ej_compra.model.Cliente;
import org.example.ej_compra.repository.IClienteRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public ClienteDto saveCliente(ClienteDto clienteDto) {
        Cliente cliente = mapper.map(clienteDto, Cliente.class);

        cliente = repository.save(cliente);

        return mapper.map(cliente, ClienteDto.class);
    }

    @Override
    public List<ClienteResponseDto> getAllClientes() {

        List<Cliente> cliente = repository.findAll();

        return cliente.stream().map(cliente1 -> mapper.map(cliente1, ClienteResponseDto.class))
                .toList();
    }


}
