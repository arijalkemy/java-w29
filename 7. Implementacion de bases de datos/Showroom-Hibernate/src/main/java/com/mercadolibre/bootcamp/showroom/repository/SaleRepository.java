package com.mercadolibre.bootcamp.showroom.repository;

import com.mercadolibre.bootcamp.showroom.model.Garment;
import com.mercadolibre.bootcamp.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT g FROM Sale s JOIN s.garmentList g WHERE s.soldOn = :date")
    List<Garment> findGarmentByDate(@Param("date") LocalDate date);

    @Query("SELECT g FROM Sale s JOIN s.garmentList g WHERE s.id = :saleId")
    List<Garment> findGarmentBySaleId(@Param("saleId") Long saleId);

}
