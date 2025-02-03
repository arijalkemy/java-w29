package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RepositoryTest {

    StudentRepository repository = new StudentRepository();

    @Test
    @DisplayName("findAll - Happy Path")
    void findAllOk() {
        //arrange
        SubjectDTO mateJuan = new SubjectDTO("Matemática", 9.00);
        SubjectDTO fisicaJuan = new SubjectDTO("Física", 7.00);
        SubjectDTO quimicaJuan = new SubjectDTO("Química", 6.00);

        SubjectDTO matePedro = new SubjectDTO("Matemática", 10.00);
        SubjectDTO fisicaPedro = new SubjectDTO("Física", 8.00);
        SubjectDTO quimicaPedro = new SubjectDTO("Química", 4.00);

        StudentDTO juan = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(mateJuan, fisicaJuan, quimicaJuan)
        );
        StudentDTO pedro = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                List.of(matePedro, fisicaPedro, quimicaPedro)
        );

        Set<StudentDTO> expected = new HashSet<>();
        expected.add(juan);
        expected.add(pedro);

        //act
        Set<StudentDTO> actual = repository.findAll();

        //assert
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
