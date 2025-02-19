package com.example.ejercicioextra1.repository;

import com.example.ejercicioextra1.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda, Long> {

    List<Prenda> findAllByTalle(String talle);
    List<Prenda> findAllByNombre(String nombre);
    List<Prenda> findAllByVentaId(Long id);

}
