package org.melibootcamp.bonusej1.repository;

import org.melibootcamp.bonusej1.entity.Garment;
import org.melibootcamp.bonusej1.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ISalesRepository extends JpaRepository<Sale, Long> {
    Sale save(Sale sale);
    boolean existsById(Long id);
    void deleteById(Long id);
    List<Sale> findAll();
    Optional<Sale> findSaleById(Long id);
    List<Sale> findSaleByDate(LocalDate date);
    @Query("select u.garments FROM Sale u where :id =u.id")
    List<Garment> findGarmentById(@Param("id") Long id);
}
