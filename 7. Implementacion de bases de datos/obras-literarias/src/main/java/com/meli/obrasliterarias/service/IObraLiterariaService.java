package com.meli.obrasliterarias.service;

import com.meli.obrasliterarias.dto.response.ObraResponseDTO;
import com.meli.obrasliterarias.dto.response.request.CreateObraDTO;
import com.meli.obrasliterarias.entity.ObraLiteraria;

import java.util.List;

public interface IObraLiterariaService {
    ObraResponseDTO save(ObraLiteraria o);
    List<ObraResponseDTO> findByAutor(String autor);
    List<ObraResponseDTO> findByNombre(String nombre);
    List<ObraResponseDTO> findTop5ByOrderByCantidadPaginasDesc();
    List<ObraResponseDTO> findByAnioPublicacion(int anioPublicacion);
    List<ObraResponseDTO> findByEditorial(String editorial);
}
