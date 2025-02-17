package com.meli.jpa_hibernate.repository;

import com.meli.jpa_hibernate.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {}
