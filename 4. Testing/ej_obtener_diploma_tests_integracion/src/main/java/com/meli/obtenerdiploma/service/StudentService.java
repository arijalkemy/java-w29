package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final IStudentDAO studentDAO;

    private final IStudentRepository studentRepository;

    @Override
    public void create(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public StudentDTO read(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public void update(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public void delete(Long id) {
        studentDAO.delete(id);
    }

    @Override
    public Set<StudentDTO> getAll() {
        return this.studentRepository.findAll();
    }
}
