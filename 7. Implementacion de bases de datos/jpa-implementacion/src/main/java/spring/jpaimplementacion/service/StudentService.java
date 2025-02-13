package spring.jpaimplementacion.service;

import org.springframework.stereotype.Service;
import spring.jpaimplementacion.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;


    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


}

