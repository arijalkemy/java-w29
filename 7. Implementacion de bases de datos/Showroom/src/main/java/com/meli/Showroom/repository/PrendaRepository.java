package com.meli.Showroom.repository;

import com.meli.Showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Integer> {

    @Query("select p from Prenda p where p.talla = :talla")
    public List<Prenda> findPrendasByTalla(@Param("talla") String talla);

    @Query("select p from Prenda p where p.codigo = :codigo")
    public Prenda findPrendasByCodigo(@Param("codigo") Integer codigo);

    @Query("select p from Prenda p where LOWER(p.nombre) like LOWER(CONCAT('%', :nombre, '%'))")
    public List<Prenda> findPrendasByNombreContaining(@Param("nombre") String nombre);
}
