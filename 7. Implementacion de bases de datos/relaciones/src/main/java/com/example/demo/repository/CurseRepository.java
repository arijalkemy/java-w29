package com.example.demo.repository;

import com.example.demo.entity.Curse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurseRepository extends JpaRepository<Curse, Long> {
}
