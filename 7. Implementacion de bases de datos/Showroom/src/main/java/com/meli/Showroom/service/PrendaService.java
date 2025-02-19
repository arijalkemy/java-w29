package com.meli.Showroom.service;

import com.meli.Showroom.dto.PrendaDto;
import com.meli.Showroom.model.Prenda;
import com.meli.Showroom.repository.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService implements IPrendaService{

    private final PrendaRepository prendaRepo;
    private final ModelMapper modelMapper;

    public PrendaService(PrendaRepository prendaRepo) {
        this.prendaRepo = prendaRepo;
        modelMapper = new ModelMapper();
    }


    @Override
    public PrendaDto save(PrendaDto prendaDto) {
        prendaRepo.save(modelMapper.map(prendaDto, Prenda.class));
        return prendaDto;
    }

    @Override
    public List<PrendaDto> searchAll(String nombre) {
        if(nombre != null){
            searchByNombre(nombre);
        }
        List<Prenda> prendas = prendaRepo.findAll();
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }

    @Override
    public List<PrendaDto> searchByTalla(String talla) {
        List<Prenda> prendas = prendaRepo.findPrendasByTalla(talla);
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }

    @Override
    public List<PrendaDto> searchByNombre(String nombre) {
        List<Prenda> prendas = prendaRepo.findPrendasByTalla(nombre);
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }

    @Override
    public PrendaDto searchByCode(Integer code) {
        Prenda prenda = prendaRepo.findPrendasByCodigo(code);
        return modelMapper.map(prenda, PrendaDto.class);
    }

    @Override
    public PrendaDto modify(Integer code, PrendaDto prendaDto) {
        Prenda prenda = prendaRepo.findPrendasByCodigo(code);
        prenda.setCodigo(prendaDto.getCodigo());
        prenda.setNombre(prendaDto.getNombre());
        prenda.setTipo(prendaDto.getTipo());
        prenda.setMarca(prendaDto.getMarca());
        prenda.setColor(prendaDto.getColor());
        prenda.setTalla(prendaDto.getTalla());
        prenda.setCantidad(prendaDto.getCantidad());
        prenda.setPrecioVenta(prendaDto.getPrecioVenta());
        prendaRepo.save(prenda);
        return modelMapper.map(prenda, PrendaDto.class);
    }

    @Override
    public PrendaDto delete(Integer code) {
        Prenda prenda = prendaRepo.findPrendasByCodigo(code);
        prendaRepo.delete(prenda);
        return modelMapper.map(prenda, PrendaDto.class);
    }
}
