package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;
    @InjectMocks
    private CharacterRepositoryImpl characterRepositoryImpl;

    @InjectMocks
    private FindService findService ;

    @Test
    void find() {
        // Arrange
        String query = "luke";

        // Act
        List<CharacterDTO> result = findService.find(query);
        System.out.println(result);

    }
}