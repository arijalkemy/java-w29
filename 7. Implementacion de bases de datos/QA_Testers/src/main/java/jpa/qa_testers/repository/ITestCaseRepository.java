package jpa.qa_testers.repository;

import jpa.qa_testers.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    Optional<List<TestCase>> findTestCasesByLastUpdateIs(LocalDate lastUpdate);
    Optional<List<TestCase>> findTestCasesByTestedIsTrue();
}