package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;

@AutoConfigureMockMvc
@SpringBootTest
public class FindControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindService findService;

    @ParameterizedTest
    @DisplayName("Find all characters by name query")
    @MethodSource("characterTestCases")
    void testFindCharacterByName(String name, List<CharacterDTO> expectedCharacters) throws Exception {
        given(findService.find(name)).willReturn(expectedCharacters);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/{name}", name))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());

        for (int i = 0; i < expectedCharacters.size(); i++) {
            String expectedName = expectedCharacters.get(i).getName();
            result.andExpect(jsonPath("$[" + i + "].name").value(expectedName));
        }
    }

    static Stream<Arguments> characterTestCases() {
        CharacterDTO luke = new CharacterDTO("Luke Skywalker");
        CharacterDTO leia = new CharacterDTO("Leia Organa");
        CharacterDTO han = new CharacterDTO("Han Solo");
        CharacterDTO chewie = new CharacterDTO("Chewbacca");

        return Stream.of(
                Arguments.of("Luke", List.of(luke)),
                Arguments.of("a", List.of(luke, leia, han, chewie)),
                Arguments.of("Vader", List.of())
        );
    }
}
