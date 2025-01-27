package com.thiagoschreck.local.melisocial.repository;

import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.entity.user.Seller;

import java.util.Optional;

import java.util.List;

public interface IUsersRepository {
	Client save(Client client);

	Seller save(Seller seller);

    Client update(Integer id, Client client);
    Seller update(Integer id, Seller client);


    Optional<Client> findClientById(int userId);

    Optional<Client> findClientById(int userId, String order);

    Optional<Seller> findSellerById(int sellerId);

    Optional<Seller> findSellerById(int sellerId, String order);
}
