package org.example.ej_compra.service;

import lombok.RequiredArgsConstructor;
import org.example.ej_compra.dto.CompraDto;
import org.example.ej_compra.model.Cliente;
import org.example.ej_compra.model.Compra;
import org.example.ej_compra.repository.IClienteRepository;
import org.example.ej_compra.repository.ICompraRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraServiceimpl implements ICompraService {

    private final ICompraRepository repository;
    private final IClienteRepository repositoryCliente;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<CompraDto> getAllCompras() {

        List<Compra> compra = repository.findAll();

        return compra.stream().map(compra1 -> mapper.map(compra1, CompraDto.class))
                .toList();

    }

    @Override
    public CompraDto saveCompra(Long clienteId, CompraDto compraDto) {
        Cliente cliente = repositoryCliente.findById(clienteId).orElseThrow(() -> new IllegalArgumentException("No found id"));
        Compra compra = mapper.map(compraDto, Compra.class);
        compra = repository.save(new Compra(cliente, compra.getFecha(), compra.getMontoTotal()));

        return mapper.map(compra, CompraDto.class);
    }

}
