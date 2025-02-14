package com.testcase.apitestcase.repository;

import com.testcase.apitestcase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    @Query("SELECT t FROM TestCase t WHERE t.last_update > :lastUpdate")
    List<TestCase> findByLastUpdateAfter(LocalDate date);
}
