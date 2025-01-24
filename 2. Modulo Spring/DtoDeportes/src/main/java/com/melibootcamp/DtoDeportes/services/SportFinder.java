package com.melibootcamp.DtoDeportes.services;

import com.melibootcamp.DtoDeportes.entity.Sport;
import com.melibootcamp.DtoDeportes.repository.SportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportFinder implements ISportFinder {
    @Override
    public List<Sport> findSports() {
        return SportRepository.getSports();
    }

    @Override
    public  Sport findSport(String name) {
        return SportRepository.findSport(name);
    }


    @Override
    public void createSport(String name, String level) {
        SportRepository.addSport(new Sport(name, level));
    }
}
