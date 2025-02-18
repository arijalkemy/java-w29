package jpa_hibernate.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import jpa_hibernate.entities.MiniSeries;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSeries, Long> {
  
}