package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.PrendaDto;
import com.bootcamp.showroom.dto.VentaDto;
import com.bootcamp.showroom.entity.Prenda;
import com.bootcamp.showroom.entity.Venta;
import com.bootcamp.showroom.repository.PrendaRepository;
import com.bootcamp.showroom.repository.VentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements IVentaService {
    private final VentaRepository ventaRepository;
    private final PrendaRepository prendaRepository;
    private final ModelMapper modelMapper;

    public VentaServiceImpl(VentaRepository ventaRepository, PrendaRepository prendaRepository) {
        this.ventaRepository = ventaRepository;
        this.prendaRepository = prendaRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public VentaDto save(VentaDto ventaDto) {
        Venta venta = modelMapper.map(ventaDto, Venta.class);
        ventaRepository.save(venta);
        return modelMapper.map(venta, VentaDto.class);
    }

    @Override
    public VentaDto findById(Long id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        return venta.map(value -> modelMapper.map(value, VentaDto.class)).orElse(null);
    }

    @Override
    public List<VentaDto> findAll() {
        return ventaRepository.findAll().stream().map(venta -> modelMapper.map(venta, VentaDto.class)).toList();
    }

    @Override
    public VentaDto update(Long numero, VentaDto ventaDto) {
        Optional<Venta> venta = ventaRepository.findById(numero);
        if (venta.isEmpty()) {
            return null;
        }

        Venta ventaUpdated = modelMapper.map(ventaDto, Venta.class);
        ventaUpdated.setNumero(numero);
        ventaUpdated = ventaRepository.save(ventaUpdated);
        return modelMapper.map(ventaUpdated, VentaDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        if (venta.isPresent()) {
            ventaRepository.delete(venta.get());
            return true;
        }
        return false;
    }
}
