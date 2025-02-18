package com.autos.empresaseguros.repository;

import com.autos.empresaseguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {
}
