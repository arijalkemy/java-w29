package com.example.demo.service;

import com.example.demo.dto.CompraDTO;
import com.example.demo.entities.Compra;
import com.example.demo.repository.ICompraRepository;
import com.example.demo.util.CompraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements ICompraService {

    private final ICompraRepository compraRepository;

    @Override
    public CompraDTO nuevaCompra(CompraDTO compra) {
        Compra compra1 = compraRepository.save(CompraMapper.INSTANCE.compraDTOToCompra(compra));
        return CompraMapper.INSTANCE.compraToCompraDTO(compra1);
    }
}
