package com.example.implnosqlvivo.services;

import com.example.implnosqlvivo.entity.ObraLiteraria;
import com.example.implnosqlvivo.repository.ObraLiterariaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ObraLiterariaServiceImpl implements IObraLiterariaService{
    private final ObraLiterariaRepository obraLiterariaRepository;

    @Override
    public ObraLiteraria guardarObra(ObraLiteraria obra) {
        return obraLiterariaRepository.save(obra);
    }

    @Override
    public Optional<ObraLiteraria> obtenerPorId(String id) {
        return obraLiterariaRepository.findById(id);
    }

    @Override
    public List<ObraLiteraria> obtenerPorAutor(String autor) {
        return obraLiterariaRepository.findByAutor(autor);
    }

    @Override
    public List<ObraLiteraria> buscarPorTitulo(String palabraClave) {
        return obraLiterariaRepository.findByNombreContaining(palabraClave);
    }

    @Override
    public List<ObraLiteraria> top5MasPaginas() {
        return obraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc();
    }

    @Override
    public List<ObraLiteraria> publicadasAntesDe(int anio) {
        return obraLiterariaRepository.findByAnioPublicacionLessThan(anio);
    }

    @Override
    public List<ObraLiteraria> obtenerPorEditorial(String editorial) {
        return obraLiterariaRepository.findByEditorial(editorial);
    }
}
