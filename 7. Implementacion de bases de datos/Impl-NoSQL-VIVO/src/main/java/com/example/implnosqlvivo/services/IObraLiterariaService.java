package com.example.implnosqlvivo.services;


import com.example.implnosqlvivo.entity.ObraLiteraria;

import java.util.List;
import java.util.Optional;

public interface IObraLiterariaService {

    ObraLiteraria guardarObra(ObraLiteraria obra);

    Optional<ObraLiteraria> obtenerPorId(String id);

    List<ObraLiteraria> obtenerPorAutor(String autor);

    List<ObraLiteraria> buscarPorTitulo(String palabraClave);

    List<ObraLiteraria> top5MasPaginas();

    List<ObraLiteraria> publicadasAntesDe(int anio);

    List<ObraLiteraria> obtenerPorEditorial(String editorial);
}
