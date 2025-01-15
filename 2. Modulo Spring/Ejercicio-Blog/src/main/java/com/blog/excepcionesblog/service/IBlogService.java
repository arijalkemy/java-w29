package com.blog.excepcionesblog.service;

import com.blog.excepcionesblog.dto.EntradaBlogDTO;

import java.util.Map;

public interface IBlogService {
    String crearEntrada(EntradaBlogDTO entradaBlogDTO);

    EntradaBlogDTO obtenerEntradaPorId(Integer id);

    Map<Integer, EntradaBlogDTO> obtenerTodasLasEntradas();
}
