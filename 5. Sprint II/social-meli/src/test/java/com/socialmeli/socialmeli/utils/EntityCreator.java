package com.socialmeli.socialmeli.utils;

import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.Product;
import com.socialmeli.socialmeli.models.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntityCreator {

    public static User getUser() {

        return new User(4, "User4", false);

    }

    public static List<User> getListOfUser() {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "User1", true));
        users.add(new User(2, "User2", false));
        users.add(new User(3, "User3", true));
        users.add(new User(4, "User4", false));
        users.add(new User(5, "User5", true));
        return users;

    }

    public static User getSeller() {

        return new User(4, "User3", true);

    }

    public static List<User> getListOfSellers() {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "User100", true));
        users.add(new User(2, "User200", true));
        return users;

    }

    public static List<Post> getPostsForUsers(List<User> users) {

        List<Post> posts = new ArrayList<>();
        LocalDate now = LocalDate.now();
        Integer cont = 0;
        for (User user : users) {
            cont++;
            posts.add(Post.builder()
                    .id(posts.size() + 1)
                    .user(user)
                    .date(now.minusDays(cont)) // Dentro de las últimas 2 semanas
                    .product(new Product()) // Asume que tienes un constructor por defecto
                    .category(1)
                    .price(100.0)
                    .hasPromo(false)
                    .discount(0.0)
                    .build());
            posts.add(Post.builder()
                    .id(posts.size() + 1)
                    .user(user)
                    .date(now.minusDays(cont + 20)) // Fuera de las últimas 2 semanas
                    .product(new Product()) // Asume que tienes un constructor por defecto
                    .category(1)
                    .price(100.0)
                    .hasPromo(false)
                    .discount(0.0)
                    .build());

        }

        return posts;

    }

}
