package com.meli.socialmeli.repository;

import java.util.Optional;

import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;

public interface IUserRepository {
    Optional<User> getById(Integer id);
    Optional<User> save(User user);
    boolean followSeller(User user, Seller seller);
    boolean isFollower(User user, Seller seller);
    boolean unfollowSeller(User user, Seller seller);
}
