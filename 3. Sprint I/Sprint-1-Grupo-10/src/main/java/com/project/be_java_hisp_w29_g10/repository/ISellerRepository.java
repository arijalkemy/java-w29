package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerRepository {
    Optional<Seller> findById(Long id);
}
