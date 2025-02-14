package com.example.compras.service;

import com.example.compras.dto.request.CompraRequestDto;
import com.example.compras.dto.response.CompraResponseDto;
import com.example.compras.exceptions.NotFoundException;
import com.example.compras.model.Cliente;
import com.example.compras.model.CompraKey;
import com.example.compras.repository.ClienteRepository;
import com.example.compras.repository.CompraRepository;
import com.example.compras.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;

    private final ClienteRepository clienteRepository;

    @Override
    public List<CompraResponseDto> getCompras() {
        return compraRepository.findAll().stream().map(Mapper::toCompraResponseDto).toList();
    }

    @Override
    public void saveCompra(Long clienteId, CompraRequestDto compra) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new NotFoundException("Cliente not found"));
        compraRepository.save(Mapper.toCompra(cliente, compra.fecha(), compra.monto()));
    }

    @Override
    public CompraResponseDto getCompra(Long clienteId, LocalDate fecha) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new NotFoundException("Cliente not found"));
        return compraRepository.findById(new CompraKey(cliente, fecha))
                .map(Mapper::toCompraResponseDto)
                .orElseThrow(() -> new NotFoundException("Compra not found"));
    }
}
