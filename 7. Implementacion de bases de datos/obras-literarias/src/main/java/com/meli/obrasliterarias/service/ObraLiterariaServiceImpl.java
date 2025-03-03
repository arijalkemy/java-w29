package com.meli.obrasliterarias.service;

import com.meli.obrasliterarias.dto.response.ObraResponseDTO;
import com.meli.obrasliterarias.dto.response.request.CreateObraDTO;
import com.meli.obrasliterarias.entity.ObraLiteraria;
import com.meli.obrasliterarias.repository.IObraLiterariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {
    private final IObraLiterariaRepository repository;
    private final ModelMapper mp;

    public ObraLiterariaServiceImpl(IObraLiterariaRepository repository) {
        this.repository = repository;
        this.mp = new ModelMapper();
    }

    @Override
    public ObraResponseDTO save(ObraLiteraria o) {
        repository.save(o);
        return mp.map(o, ObraResponseDTO.class);
    }

    @Override
    public List<ObraResponseDTO> findByAutor(String autor) {
        List<ObraLiteraria> obras = repository.findByAutor(autor);
        return obras.stream().map(o -> mp.map(o, ObraResponseDTO.class)).toList();
    }

    @Override
    public List<ObraResponseDTO> findByNombre(String nombre) {
        List<ObraLiteraria> obras = repository.findByNombre(nombre);
        return obras.stream().map(o -> mp.map(o, ObraResponseDTO.class)).toList();
    }

    @Override
    public List<ObraResponseDTO> findTop5ByOrderByCantidadPaginasDesc() {
        List<ObraLiteraria> obras = repository.findTop5ByOrderByCantidadPaginasDesc();
        return obras.stream().map(o -> mp.map(o, ObraResponseDTO.class)).toList();
    }

    @Override
    public List<ObraResponseDTO> findByAnioPublicacion(int anioPublicacion) {
        List<ObraLiteraria> obras = repository.findByAnioPublicacion(anioPublicacion);
        return obras.stream().map(o -> mp.map(o, ObraResponseDTO.class)).toList();
    }

    @Override
    public List<ObraResponseDTO> findByEditorial(String editorial) {
        List<ObraLiteraria> obras = repository.findByEditorial(editorial);
        return obras.stream().map(o -> mp.map(o, ObraResponseDTO.class)).toList();
    }
}
