package com.example.deportes.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.deportes.repository.SportRepository;
import com.example.deportes.model.entity.Sport;
import java.util.List;

@Service
@NoArgsConstructor
public class SportService {
    private final SportRepository sportRepository = new SportRepository();

    public List<Sport> getAllSports() {
        return sportRepository.getAll();
    }

    public Sport getSportByName(String name) {
        return sportRepository.getOneByName(name);
    }
}
