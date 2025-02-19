package com.bootcamp.crudjpa.repository;

import com.bootcamp.crudjpa.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    public List<TestCase> findByLastUpdateAfter(LocalDate date);
}
