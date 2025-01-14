package com.example.starswar.Repositories;

import com.example.starswar.Models.Characterer;

import java.util.List;

public interface IAppRepository {
    List<Characterer> readStarWarsData();
}
