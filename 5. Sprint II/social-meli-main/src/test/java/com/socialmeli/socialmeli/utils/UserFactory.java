package com.socialmeli.socialmeli.utils;

import com.socialmeli.socialmeli.dto.response.UserDto;
import com.socialmeli.socialmeli.models.User;

import java.util.List;

public class UserFactory {

    public static User createSeller(Integer id) {
        return new User(id, null, true);
    }

    public static User createBuyer(Integer id) {
        return new User(id, null, false);
    }

    public static User createSeller(Integer id, String name) {
        return new User(id, name, true);
    }

    public static User createBuyer(Integer id, String name) {
        return new User(id, name, false);
    }

    public static List<User> getListOfSellers() {
        return List.of(createSeller(1), createSeller(2));
    }

    public static List<User> getFollowersListForUser1Desc() {
        User user4 = UserFactory.createBuyer(4, "Eliana Navarro");
        User user6 = UserFactory.createBuyer(6, "Katerinne Peralta");
        User user2 = UserFactory.createBuyer(2, "Carolina Comba");
        return List.of(user6, user4, user2);
    }

    public static List<User> getFollowersListForUser1Asc() {
        User user2 = UserFactory.createBuyer(2, "Carolina Comba");
        User user6 = UserFactory.createBuyer(6, "Katerinne Peralta");
        User user4 = UserFactory.createBuyer(4, "Eliana Navarro");
        return List.of(user2, user4, user6);
    }

    public static List<User> getFollowedListForUser2Asc() {
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        User user3 = UserFactory.createSeller(3, "Ciro Sánchez");
        User user5 = UserFactory.createSeller(5, "Franca Pairetti");

        return List.of(user1, user3, user5);
    }

    public static List<User> getFollowedListForUser2Desc() {
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        User user3 = UserFactory.createSeller(3, "Ciro Sánchez");
        User user5 = UserFactory.createSeller(5, "Franca Pairetti");

        return List.of(user5, user3, user1);
    }

    public static List<UserDto> createListUserDtoAsc() {
        return List.of(
                new UserDto(2, "Carolina Comba"),
                new UserDto(4, "Eliana Navarro"),
                new UserDto(6, "Katerinne Peralta")
        );
    }

    public static List<UserDto> createListUserDtoDesc() {
        return List.of(
                new UserDto(6, "Katerinne Peralta"),
                new UserDto(4, "Eliana Navarro"),
                new UserDto(2, "Carolina Comba")
        );
    }

    public static List<UserDto> createListSellerAsc() {
        return List.of(
                new UserDto(1, "Agostina Avalle"),
                new UserDto(3, "Ciro Sánchez")
        );
    }

    public static List<UserDto> createListSellerDesc() {
        return List.of(
                new UserDto(3, "Ciro Sánchez"),
                new UserDto(1, "Agostina Avalle")
        );
    }
}
