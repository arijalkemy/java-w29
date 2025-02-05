package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements  IUserRepository{
    List<User> users;

    public UserRepositoryImpl() {
        users = new ArrayList<>(List.of(
                new User(1L, "Alice"),
                new User(2L, "Bob"),
                new User(3L, "Charlie"),
                new User(4L, "David"),
                new User(5L, "Eva"),
                new User(6L, "Frank"),
                new User(7L, "Grace"),
                new User(8L, "Hannah"),
                new User(9L, "Ivy"),
                new User(10L, "Jack")
        ));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getUser_id().equals(id)).findFirst();
    }
}
