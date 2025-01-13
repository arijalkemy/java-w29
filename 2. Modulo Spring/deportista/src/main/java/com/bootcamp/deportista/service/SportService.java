package com.bootcamp.deportista.service;

import com.bootcamp.deportista.domain.Sport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SportService {
    public List<Sport> getSports(){
        return sportList;
    }
    public Optional<Sport> getSportByName(String name){
        return sportList.stream().filter(s -> s.getName().equals(name)).findFirst();
    }
    Sport basket = new Sport("basket", "hard");
    Sport football = new Sport("football", "medium");

    List<Sport> sportList = Arrays.asList(basket, football);
}
