package com.mdaneri.caloriasp2vivo1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdaneri.caloriasp2vivo1.entity.Dish;
import com.mdaneri.caloriasp2vivo1.entity.Food;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public class FileDishRepositoryImpl implements IFileDishRepository {

    private List<Food> foods = new ArrayList<>();
    private List<Dish> dishes = new ArrayList<>();

    public FileDishRepositoryImpl() throws IOException {
        loadDataBase();

        dishes.add(new Dish("Pizza", List.of(foods.get(5), foods.get(10), foods.get(1))));
        dishes.add(new Dish("Fideos", List.of(foods.get(12), foods.get(10), foods.get(2))));
        dishes.add(new Dish("Milanesa", List.of(foods.get(11), foods.get(9), foods.get(5))));
        dishes.add(new Dish("Ensalada", List.of(foods.get(5), foods.get(10))));
    }

    @Override
    public Optional<Dish> findByName(String name) {
        return dishes
                .stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public List<Dish> findByNames(Collection<String> names) {
        return dishes.stream().filter(d -> names.contains(d.getName())).toList();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Food> foods;

        file = ResourceUtils.getFile("classpath:data.json");
        foods = objectMapper.readValue(file,new TypeReference<List<Food>>(){});

        this.foods = foods;
    }

}
