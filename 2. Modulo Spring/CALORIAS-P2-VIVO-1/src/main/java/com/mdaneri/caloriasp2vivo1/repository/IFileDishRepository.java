package com.mdaneri.caloriasp2vivo1.repository;

import com.mdaneri.caloriasp2vivo1.entity.Dish;
import com.mdaneri.caloriasp2vivo1.entity.Food;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IFileDishRepository {

    List<Dish> findByNames(Collection<String> names);
    Optional<Dish> findByName(String name);

}
