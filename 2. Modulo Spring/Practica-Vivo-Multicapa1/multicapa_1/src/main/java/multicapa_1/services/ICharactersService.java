package multicapa_1.services;

import java.util.List;

import multicapa_1.dtos.responseCharacterDto;

public interface ICharactersService {
    public List<responseCharacterDto> findByName(String name);
}
