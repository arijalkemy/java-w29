package com.thiagoschreck.local.melisocial.repository;

import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.entity.user.Seller;

import java.util.Optional;

public interface IUsersRepository {
    Client save(Client client);

    Seller save(Seller seller);

    Optional<Client> findClientById(int userId);

    Optional<Client> findClientById(int userId, String order);

    Optional<Seller> findSellerById(int sellerId);

    Optional<Seller> findSellerById(int sellerId, String order);
}
