package com.example.practgicaHibernateVivo.repository;

import com.example.practgicaHibernateVivo.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
