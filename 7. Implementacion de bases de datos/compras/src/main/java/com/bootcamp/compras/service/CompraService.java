package com.bootcamp.compras.service;

import com.bootcamp.compras.dto.CompraDto;
import com.bootcamp.compras.model.Compra;
import com.bootcamp.compras.repository.CompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CompraService {
    private CompraRepository repo;
    private ModelMapper mapper;

    @Autowired
    public CompraService(CompraRepository repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }

    public CompraDto saveCompra(CompraDto compraDto){
        Compra compra = mapper.map(compraDto, Compra.class);
        compra.setFecha(LocalDate.now());
        repo.save(compra);
        return compraDto;
    }
}
