package spring.jpaimplementacion.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spring.jpaimplementacion.model.Student;
import spring.jpaimplementacion.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository repository;


    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public void saveStudent(Student stu) {
        repository.save(stu);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student findStudent(Long id) {
        return repository.findById(id).orElse(null);
    }
}

