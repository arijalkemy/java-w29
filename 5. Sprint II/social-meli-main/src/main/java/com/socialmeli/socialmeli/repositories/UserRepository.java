package com.socialmeli.socialmeli.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.socialmeli.socialmeli.models.User;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Getter
public class UserRepository implements IUserRepository {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("classpath:users.json");
        this.users = objectMapper.readValue(file, new TypeReference<>() { });
    }

    @Override
    public Optional<User> findById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public void update(User user) {
        users = users.stream()
                .map(u -> u.getId().equals(user.getId()) ? user : u)
                .toList();
    }
}
