package com.org.meli.joyeria.repository;

import com.org.meli.joyeria.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
    List<Joya> findByVentaONoTrue();
}
