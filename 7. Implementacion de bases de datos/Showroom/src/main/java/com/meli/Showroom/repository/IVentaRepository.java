package com.meli.Showroom.repository;

import com.meli.Showroom.model.Prenda;
import com.meli.Showroom.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {
    @Query("select v from Venta v where v.numero = :numero")
    public Venta findVentaByNumero(@Param("numero") Integer numero);

    @Query("select v from Venta v where v.fecha = :fecha")
    public List<Venta> findVentasByFecha(@Param("fecha") LocalDate fecha);
}
