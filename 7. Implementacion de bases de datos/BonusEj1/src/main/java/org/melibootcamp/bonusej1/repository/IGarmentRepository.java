package org.melibootcamp.bonusej1.repository;

import org.melibootcamp.bonusej1.entity.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

@Repository
public interface IGarmentRepository extends JpaRepository<Garment, Long> {
     Garment save(Garment garment);
     boolean existsById(Long id);
     void deleteById(Long id);
     List<Garment> findAll();
     Optional<Garment> findPrendasById(Long id);
     List<Garment> findGarmentByNameContainingIgnoreCase(String name);
     List<Garment> findGarmentBySize(String size);
}
