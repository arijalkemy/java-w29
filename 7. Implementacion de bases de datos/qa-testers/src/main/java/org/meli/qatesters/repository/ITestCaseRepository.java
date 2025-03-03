package org.meli.qatesters.repository;

import org.meli.qatesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    Optional<TestCase> findById(Long id);

    @Query("SELECT t FROM TestCase t WHERE t.lastUpdate = :date")
    List<TestCase> findAllByDate(LocalDate date);
}
