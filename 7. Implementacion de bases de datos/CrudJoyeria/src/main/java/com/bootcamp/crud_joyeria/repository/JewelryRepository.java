package com.bootcamp.crud_joyeria.repository;

import com.bootcamp.crud_joyeria.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JewelryRepository extends JpaRepository<Jewel, Long> {
    List<Jewel> findJewelsBySellableIsTrue();
    Optional<Jewel> findJewelByIdAndSellableIsTrue(Long id);
}
