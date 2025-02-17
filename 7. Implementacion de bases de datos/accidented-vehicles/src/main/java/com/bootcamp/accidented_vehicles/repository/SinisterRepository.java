package com.bootcamp.accidented_vehicles.repository;

import com.bootcamp.accidented_vehicles.model.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinisterRepository extends JpaRepository<Sinister, Integer> {

}
