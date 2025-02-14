package com.example.exerciseJoyeriaHibernate.repository;

import com.example.exerciseJoyeriaHibernate.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoyaRepository extends JpaRepository<Joya, Long> {
    List<Joya> findByVentaONoTrue();
}
