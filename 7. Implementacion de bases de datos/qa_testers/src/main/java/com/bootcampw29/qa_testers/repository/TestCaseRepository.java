package com.bootcampw29.qa_testers.repository;

import com.bootcampw29.qa_testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long>, JpaSpecificationExecutor<TestCase> {
    List<TestCase> findAllByLastUpdateAfter(LocalDate date);
}
