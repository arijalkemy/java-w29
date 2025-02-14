package pruebas_jpa.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pruebas_jpa.entity.Student;
import pruebas_jpa.repository.StudentRepository;

import java.util.List;


@Service
public class StudentService implements IStudentService{
    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo){
        this.stuRepo = stuRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Student> getStudents(){
        List<Student> studentList = stuRepo.findAll(); //Devuelve una List<T> y T es el tipo de dato
        return studentList;
    }

    @Override
    @Transactional
    public void saveStudent(Student stu){
        stuRepo.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(long id){
        stuRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Student findStudent(long id){
        return stuRepo.findById(id).orElse(null);
    }
}
