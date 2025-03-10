package meli.qatesters.repository;

import meli.qatesters.dto.response.TestCaseDTO;
import meli.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository <TestCase, Long> {
    List<TestCase> findTestCaseByLastUpdateAfter(LocalDate lastUpdate);

}
