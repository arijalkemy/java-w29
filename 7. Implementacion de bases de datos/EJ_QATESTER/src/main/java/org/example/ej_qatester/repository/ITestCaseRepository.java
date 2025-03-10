package org.example.ej_qatester.repository;

import org.example.ej_qatester.dto.TestCaseDto;
import org.example.ej_qatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCaseDto> findByLastUpdateAfter(LocalDate lastUpdateAfter);
}
