package com.meli.socialmeli.repository;

import java.util.Optional;

import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;

public interface ISellerRepository {
    Optional<Seller> save(Seller seller);
    Optional<Seller> getById(Integer id);
    boolean addFollower(Seller seller, User user);
    boolean isFollower(Seller seller, User user);
    boolean removeFollower(Seller seller, User user);
    int countSellers();
}
