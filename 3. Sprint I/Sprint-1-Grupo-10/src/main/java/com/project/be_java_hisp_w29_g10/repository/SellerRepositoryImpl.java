package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.entity.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SellerRepositoryImpl implements ISellerRepository {

    List<Seller> sellers;

    public SellerRepositoryImpl() {
        sellers = new ArrayList<>(List.of(
                new Seller(1L, "Andrés", "300-123-4567"),
                new Seller(2L, "Beatriz", "310-234-5678"),
                new Seller(3L, "Carlos", "320-345-6789"),
                new Seller(4L, "Diana", "350-456-7890"),
                new Seller(5L, "Elena", "301-567-8901"),
                new Seller(6L, "Fernando", "311-678-9012"),
                new Seller(7L, "Gloria", "321-789-0123"),
                new Seller(8L, "Hernando", "351-890-1234"),
                new Seller(9L, "Isabela", "302-901-2345"),
                new Seller(10L, "Jorge", "312-012-3456")
        ));
    }

    @Override
    public Optional<Seller> findById(Long id) {
        return sellers.stream().filter(seller -> seller.getId_seller().equals(id)).findFirst();
    }
}