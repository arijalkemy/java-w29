package com.thiagoschreck.local.melisocial.entity.user;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Seller extends User {
    private final List<Client> followers = new ArrayList<>();

    public Seller(String userName) {
        super(userName);
    }

    public void addFollower(Client client) {
        followers.add(client);
    }
}
