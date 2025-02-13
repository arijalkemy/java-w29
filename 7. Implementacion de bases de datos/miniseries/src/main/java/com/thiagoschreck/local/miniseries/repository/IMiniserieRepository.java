package com.thiagoschreck.local.miniseries.repository;

import com.thiagoschreck.local.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
