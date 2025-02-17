package com.bootcampw29.jewelry.repository;

import com.bootcampw29.jewelry.model.Jewel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JewelRepository extends CrudRepository<Jewel, Long> {
    List<Jewel> findAllByIsForSaleTrue();
}
