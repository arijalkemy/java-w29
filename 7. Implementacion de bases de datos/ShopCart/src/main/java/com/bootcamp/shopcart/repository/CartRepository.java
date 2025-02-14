package com.bootcamp.shopcart.repository;

import com.bootcamp.shopcart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
