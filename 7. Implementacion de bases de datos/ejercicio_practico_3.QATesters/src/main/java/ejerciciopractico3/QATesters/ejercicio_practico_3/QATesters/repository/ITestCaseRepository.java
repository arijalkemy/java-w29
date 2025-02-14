package ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.repository;

import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findTestCasesByLastUpdateAfter(Date lastUpdate);
}
