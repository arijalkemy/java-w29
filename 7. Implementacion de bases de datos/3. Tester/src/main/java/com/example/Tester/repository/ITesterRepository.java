package com.example.Tester.repository;

import com.example.Tester.entity.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITesterRepository extends JpaRepository<Tester, Long> {
    List<Tester> findByLastUpdateAfter(LocalDate lastUpdate);
}
