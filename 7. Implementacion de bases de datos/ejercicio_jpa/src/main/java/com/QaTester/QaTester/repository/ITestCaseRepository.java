package com.QaTester.QaTester.repository;

import com.QaTester.QaTester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase,Long>{
}
