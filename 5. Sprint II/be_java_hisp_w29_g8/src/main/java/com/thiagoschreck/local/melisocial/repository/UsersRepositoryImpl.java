package com.thiagoschreck.local.melisocial.repository;

import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl implements IUsersRepository {
    private int identity = 1;

    private Map<Integer, Client> clients;
    private Map<Integer, Seller> sellers;

    public UsersRepositoryImpl() {
        clients = new HashMap<>();
        sellers = new HashMap<>();
    }

    public Client save(Client client) {
        client.setUserId(identity++);
        clients.put(client.getUserId(), client);
        return client;
    }

	public Seller save(Seller seller) {
		seller.setUserId(identity++);
		sellers.put(seller.getUserId(), seller);
		return seller;
	}


    @Override
    public Optional<Seller> findSellerById(int sellerId) {
        return Optional.ofNullable(sellers.get(sellerId));
    }

    @Override
    public Optional<Seller> findSellerById(int userId, String order) {
        Optional<Seller> sellerOptional = Optional.ofNullable(sellers.get(userId));
        sellerOptional.ifPresent(seller -> {
            List<Client> orderedFollowers = seller.getFollowers().stream()
                    .sorted(getClientComparator(order))
                    .toList();
            seller.getFollowers().clear();
            seller.getFollowers().addAll(orderedFollowers);
        });
        return sellerOptional;
    }

    @Override
    public Optional<Client> findClientById(int userId) {
        return Optional.ofNullable(clients.get(userId));
    }

    public Optional<Client> findClientById(int userId, String order) {
        Optional<Client> clientOptional = Optional.ofNullable(clients.get(userId));
        clientOptional.ifPresent(client -> {
            List<Seller> orderedFollowing = client.getFollowing().stream()
                    .sorted(getSellerComparator(order))
                    .toList();
            client.getFollowing().clear();
            client.getFollowing().addAll(orderedFollowing);
        });
        return clientOptional;
    }

    public void resetDb(){
        identity = 1;
        clients = new HashMap<>();
        sellers = new HashMap<>();
    }

    private Comparator<Seller> getSellerComparator(String order) {
        if (order.equalsIgnoreCase("name_desc")) {
            return Comparator.comparing(Seller::getUserName).reversed();
        }
        return Comparator.comparing(Seller::getUserName);
    }

    private Comparator<Client> getClientComparator(String order) {
        if (order.equalsIgnoreCase("name_desc")) {
            return Comparator.comparing(Client::getUserName).reversed();
        }
        return Comparator.comparing(Client::getUserName);
    }
}
