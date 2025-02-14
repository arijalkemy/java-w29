package com.meli.socialmeli.repository;

import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private List<User> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return this.users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public boolean isFollower(User user, Seller seller) {
        return user.getFollows().contains(seller);
    }

    @Override
    public boolean followSeller(User user, Seller seller) {
        return user.getFollows().add(seller);
    }

    @Override
    public boolean unfollowSeller(User user, Seller seller) {
        return user.getFollows().remove(seller);
    }

    @Override
    public Optional<User> save(User user) {
        Optional<User> userOptional = this.getById(user.getId());
        if (userOptional.isPresent()) {
            return userOptional;
        }

        if (user.getId() == null) {
            user.setId(this.users.size() + 1);
        }

        this.users.add(user);

        return Optional.of(user);
    }

}
