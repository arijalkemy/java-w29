package com.org.meli.showroom.repository;

import com.org.meli.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByDate(Date date);
}
