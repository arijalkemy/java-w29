package com.example.vehicles.repository;

import com.example.vehicles.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccidentRepository extends JpaRepository<Accident, Long> {
}
