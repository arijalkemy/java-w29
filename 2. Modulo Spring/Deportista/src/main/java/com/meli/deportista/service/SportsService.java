package com.meli.deportista.service;

import com.meli.deportista.model.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SportsService {
    List<Sport> sports;

    public SportsService() {
        sports = new ArrayList<>();
    }

    public SportsService(List<Sport> sports) {
        this.sports = sports;
    }

    public List<Sport> getSports() {
        return this.sports;
    }

    public Optional<Sport> getSportByName(String name) {

        for (Sport sport : this.sports) {
            if (sport.getName().equals(name)) {
                return Optional.of(sport);
            }
        }

        return null;
    }
}
