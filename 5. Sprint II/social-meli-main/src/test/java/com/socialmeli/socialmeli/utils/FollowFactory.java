package com.socialmeli.socialmeli.utils;

import com.socialmeli.socialmeli.models.Follow;
import com.socialmeli.socialmeli.models.User;

import java.util.List;

public class FollowFactory {

    public static List<Follow> createListFollows() {
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        User user2 = UserFactory.createBuyer(2, "Carolina Comba");
        User user4 = UserFactory.createBuyer(4, "Eliana Navarro");
        User user6 = UserFactory.createBuyer(6, "Katerinne Peralta");
        return List.of(
                new Follow(user2, user1),
                new Follow(user4, user1),
                new Follow(user6, user1)
        );
    }

    public static List<Follow> createListFollowers() {
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        User user2 = UserFactory.createBuyer(2, "Carolina Comba");
        User user3 = UserFactory.createSeller(3, "Ciro Sánchez");
        return List.of(
                new Follow(user2, user1),
                new Follow(user2, user3)
        );
    }

    public static List<Follow> createListFollower() {
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        User user3 = UserFactory.createSeller(3, "Ciro Sánchez");
        User user4 = UserFactory.createBuyer(4, "Eliana Navarro");
        return List.of(new Follow(user4, user3), new Follow(user4, user1));
    }
}
