package com.example.ejercicio_blog.repository;

import com.example.ejercicio_blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaRepositoryImpl implements IEntradaRepository<EntradaBlog> {
    private static final List<EntradaBlog> entradas = new ArrayList<>();

    @Override
    public List<EntradaBlog> getAll() {
        return entradas;
    }

    @Override
    public Boolean add(EntradaBlog entrada) {
        return entradas.add(entrada);
    }

    @Override
    public Optional<EntradaBlog> findById(Integer id) {
        return entradas.stream().filter(entrada -> entrada.getId().equals(id)).findFirst();
    }
}
