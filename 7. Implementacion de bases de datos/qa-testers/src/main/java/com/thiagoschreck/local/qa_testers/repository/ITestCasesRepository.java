package com.thiagoschreck.local.qa_testers.repository;

import com.thiagoschreck.local.qa_testers.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCasesRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findByLastUpdateAfter(LocalDate lastUpdate);
}
