package com.bootcamp.compras.repository;

import com.bootcamp.compras.model.Compra;
import com.bootcamp.compras.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraKey> {}
