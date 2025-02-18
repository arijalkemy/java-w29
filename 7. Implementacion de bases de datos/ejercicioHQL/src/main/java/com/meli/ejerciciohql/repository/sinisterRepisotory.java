package com.meli.ejerciciohql.repository;

import com.meli.ejerciciohql.model.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sinisterReposotory extends JpaRepository<Sinister, Long> {
    
}
