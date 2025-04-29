package com.example.miniseries.repository;

import com.example.miniseries.model.MiniSerie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long>
public interface IMiniSerieRepository extends CrudRepository<MiniSerie, Long> {
}
