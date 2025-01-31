package com.mercadolibre.starwars.unitTest;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.utilsTest.CharacterUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FindController.class) // 🔹 Prueba solo el controlador
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindService findService;

    @Test
    void find_ShouldReturnMatchingCharacters() throws Exception {
        List<CharacterDTO> characters = List.of(
                CharacterUtils.createCharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY",
                        "male", "Tatooine", "Human", 202, 136),
                CharacterUtils.createCharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY",
                        "male", "Dathomir", "Zabrak", 175, 80)
        );

        when(findService.find("darth")).thenReturn(characters);

        this.mockMvc.perform(get("/darth")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Darth Vader"))
                .andExpect(jsonPath("$[1].name").value("Darth Maul"));

        // verify(findService, times(1)).find("darth");
    }

    @Test
    void find_ShouldReturnEmptyList_WhenNoMatches() throws Exception {
        when(findService.find("unknown")).thenReturn(List.of());

        mockMvc.perform(get("/unknown")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(findService, times(1)).find("unknown");
    }
}
