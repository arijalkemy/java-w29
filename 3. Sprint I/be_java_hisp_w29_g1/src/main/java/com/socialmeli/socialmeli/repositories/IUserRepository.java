package com.socialmeli.socialmeli.repositories;

import com.socialmeli.socialmeli.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> findById(Integer id);

    void update(User user);

    List<User> findUserSeller();
}
