package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceT {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Test find()")
    public void find() {
        String query = "a query";
        when(repository.findAllByNameContains(query)).thenReturn(new ArrayList<>());

        List<CharacterDTO> result = service.find(query);

        verify(repository).findAllByNameContains(query);
        assertEquals(new ArrayList<>(), result);
    }



}
