package com.example.testers.repository;

import com.example.testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findTestCaseByLastUpdateAfter(LocalDate lastUpdate);
}
