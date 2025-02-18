package com.meli.qatesters.repository;

import com.meli.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
