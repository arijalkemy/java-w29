package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void findTestOk(){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");
        List<CharacterDTO> listExpected = new ArrayList<>();
        listExpected.add(characterDTO);
        String query = "Luke";

        when(findService.find(query)).thenReturn(listExpected);
        List<CharacterDTO> response = findController.find(query);
        assertEquals(listExpected, response);
    }

}