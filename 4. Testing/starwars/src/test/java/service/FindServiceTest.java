package service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/*
* List<CharacterDTO> find(String query)
* */

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    void findCharacterOkTest() {
        List<CharacterDTO> characterDTOS = new ArrayList<>();

        //Arrange
        when(repository.findAllByNameContains("")).thenReturn(characterDTOS);

        //Act
        var expected = service.find("");

        //Assert
        assertEquals(characterDTOS, expected);
        verify(repository, atLeastOnce()).findAllByNameContains("");
    }
}
