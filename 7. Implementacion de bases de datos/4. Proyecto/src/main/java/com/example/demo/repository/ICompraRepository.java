package com.example.demo.repository;

import com.example.demo.entities.Compra;
import com.example.demo.entities.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, CompraKey> {
}
