package spring.jpaimplementacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.jpaimplementacion.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
