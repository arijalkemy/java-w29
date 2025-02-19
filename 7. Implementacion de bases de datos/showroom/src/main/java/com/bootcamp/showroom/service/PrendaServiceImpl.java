package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.PrendaDto;
import com.bootcamp.showroom.entity.Prenda;
import com.bootcamp.showroom.repository.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrendaServiceImpl implements IPrendaService{
    private final PrendaRepository prendaRepository;
    private final ModelMapper modelMapper;

    public PrendaServiceImpl(PrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<PrendaDto> findAll() {
        List<Prenda> prendas =  prendaRepository.findAll();
        return prendas.stream().map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }

    @Override
    public PrendaDto save(PrendaDto prendaDto) {
        Prenda prenda = modelMapper.map(prendaDto, Prenda.class);
        prenda = prendaRepository.save(prenda);
        return modelMapper.map(prenda, PrendaDto.class);
    }

    @Override
    public PrendaDto findById(Long codigo) {
        Optional<Prenda> prenda = prendaRepository.findById(codigo);
        return prenda.map(value -> modelMapper.map(value, PrendaDto.class)).orElse(null);
    }

    @Override
    public PrendaDto update(Long codigo, PrendaDto prendaDto) {
        Optional<Prenda> prenda = prendaRepository.findById(codigo);
        if(prenda.isEmpty()){
            return  null;
        }
        Prenda prendaUpdate = modelMapper.map(prendaDto, Prenda.class);
        prendaUpdate.setCodigo(codigo);
        prendaUpdate = prendaRepository.save(prendaUpdate);
        return modelMapper.map(prendaUpdate, PrendaDto.class);
    }

    @Override
    public Boolean delete(Long codigo) {
        Optional<Prenda> prenda = prendaRepository.findById(codigo);
        if(prenda.isEmpty()){
            return false;
        }
        prendaRepository.deleteById(codigo);
        return true;
    }

    @Override
    public List<PrendaDto> findByTalla(String talla) {
        return prendaRepository.findByTalla(talla).stream().map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }

    @Override
    public List<PrendaDto> findByName(String nombre) {
        return prendaRepository.findByNombre(nombre).stream().map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }
}
