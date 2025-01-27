package com.thiagoschreck.local.melisocial.entity.user;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Client extends User {
    private final List<Seller> following = new ArrayList<>();

    public Client(String userName) {
        super(userName);
    }

    public void followSeller(Seller seller) {
        following.add(seller);
    }
}
