package com.bootcamp.showroom.repository;

import com.bootcamp.showroom.dto.PrendaDto;
import com.bootcamp.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findByTalla(String talla);
    @Query("SELECT p FROM Prenda p WHERE p.nombre like %:nombre%")
    List<Prenda> findByNombre(@Param("nombre") String nombre);
}
