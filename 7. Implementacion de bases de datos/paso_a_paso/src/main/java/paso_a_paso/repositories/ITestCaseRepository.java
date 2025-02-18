package paso_a_paso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import paso_a_paso.entities.TestCase;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
  
}
