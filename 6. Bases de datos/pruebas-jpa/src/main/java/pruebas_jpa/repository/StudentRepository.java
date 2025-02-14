package pruebas_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebas_jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
