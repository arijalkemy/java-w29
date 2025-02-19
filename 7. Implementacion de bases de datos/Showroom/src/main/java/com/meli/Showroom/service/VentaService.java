package com.meli.Showroom.service;

import com.meli.Showroom.dto.PrendaDto;
import com.meli.Showroom.dto.VentaDto;
import com.meli.Showroom.model.Venta;
import com.meli.Showroom.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService implements IVentaService{

    private final IVentaRepository ventaRepo;
    private final ModelMapper modelMapper;

    public VentaService(IVentaRepository ventaRepo) {
        this.ventaRepo = ventaRepo;
        modelMapper = new ModelMapper();
    }

    @Override
    public VentaDto save(VentaDto ventaDto) {
        ventaRepo.save(modelMapper.map(ventaDto, Venta.class));
        return ventaDto;
    }

    @Override
    public List<VentaDto> searchAll() {
        List<Venta> ventas = ventaRepo.findAll();
        return ventas.stream()
                .map(venta -> modelMapper.map(venta, VentaDto.class)).toList();
    }

    @Override
    public List<PrendaDto> getPrendasByVentaNumero(Integer numero) {
        Venta venta = ventaRepo.findVentaByNumero(numero);

        return venta.getPrendas().stream()
                    .map(prenda -> modelMapper.map(prenda, PrendaDto.class))
                    .collect(Collectors.toList());

    }

    @Override
    public VentaDto searchByNumer(Integer numero) {
        Venta venta = ventaRepo.findVentaByNumero(numero);
        return modelMapper.map(venta, VentaDto.class);
    }

    @Override
    public VentaDto modify(Integer numero, VentaDto ventaDto) {
        Venta venta = ventaRepo.findVentaByNumero(numero);
        venta.setNumero(ventaDto.getNumero());
        venta.setFecha(ventaDto.getFecha());
        venta.setTotal(ventaDto.getTotal());
        venta.setMedioDePago(ventaDto.getMedioDePago());
        venta.setPrendas(ventaDto.getPrendas());
        ventaRepo.save(venta);
        return modelMapper.map(venta, VentaDto.class);
    }

    @Override
    public VentaDto delete(Integer numero) {
        Venta venta = ventaRepo.findVentaByNumero(numero);
        ventaRepo.delete(venta);
        return modelMapper.map(venta, VentaDto.class);
    }

    @Override
    public List<VentaDto> searchByFecha(LocalDate fecha) {
        List<Venta> ventas = ventaRepo.findVentasByFecha(fecha);
        return ventas.stream()
                .map(venta -> modelMapper.map(venta, VentaDto.class)).toList();
    }
}
