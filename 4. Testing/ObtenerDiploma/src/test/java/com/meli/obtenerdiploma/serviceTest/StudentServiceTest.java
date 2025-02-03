package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    final static Long ID = 1L;
    final static String NAME = "Jhon";
    public static List<SubjectDTO> subjects;
    public static StudentDTO student;

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @BeforeAll
    public static void setUp(){
        subjects = List.of(
                new SubjectDTO("Matematicas", 9.5),
                new SubjectDTO("Fisica", 9.6)
        );

        student = new StudentDTO(ID, NAME, "", 0.0, subjects);
    }

    @Test
    public void createTest(){
        Mockito.doNothing().when(studentDAO).save(student);

        studentService.create(student);

        Mockito.verify(studentDAO).save(student);
    }

    @Test
    public void readTest(){
        Mockito.when(studentDAO.findById(ID)).thenReturn(student);

        StudentDTO obtained = studentService.read(ID);

        Assertions.assertNotNull(obtained);
        Assertions.assertEquals(student.getId(), obtained.getId());
        Assertions.assertEquals(student, obtained);
    }

    @Test
    public void updateTest(){
        Mockito.doNothing().when(studentDAO).save(student);

        studentService.update(student);

        Mockito.verify(studentDAO).save(student);
    }

    @Test
    public void deleteTest(){
        Mockito.when(studentDAO.delete(ID)).thenReturn(true);

        studentService.delete(ID);

        Mockito.verify(studentDAO).delete(ID);
    }

    @Test
    public void getAllTest(){
        StudentDTO student2 = new StudentDTO(2L, "Maria", "", 0.0, List.of(
                new SubjectDTO("Quimica", 9.5),
                new SubjectDTO("Biologia", 8.7)
        ));

        Set<StudentDTO> students = new HashSet<>();
        students.add(student);
        students.add(student2);

        Mockito.when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> obtained =  studentService.getAll();

        Assertions.assertNotNull(obtained);
        Assertions.assertEquals(2, obtained.size());
        Assertions.assertEquals(students, obtained);
        Assertions.assertTrue(obtained.contains(student));
        Assertions.assertTrue(obtained.contains(student2));
    }
}
