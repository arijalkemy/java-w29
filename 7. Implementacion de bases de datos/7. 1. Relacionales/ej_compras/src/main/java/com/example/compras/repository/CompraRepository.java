package com.example.compras.repository;

import com.example.compras.model.Compra;
import com.example.compras.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraKey> {
}
