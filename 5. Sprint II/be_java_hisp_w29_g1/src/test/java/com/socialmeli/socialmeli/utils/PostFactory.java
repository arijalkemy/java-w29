package com.socialmeli.socialmeli.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import com.socialmeli.socialmeli.dto.ProductDto;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.Product;
import com.socialmeli.socialmeli.models.User;

public class PostFactory {

    public static ProductDto createProductDto(Integer id) {
        return ProductDto.builder()
                .id(id)
                .name("Product")
                .brand("Brand")
                .color("Color")
                .type("Type")
                .notes("Notes")
                .build();
    }

    public static Object createPostDto(Integer userId, Integer productId, boolean hasPromo) {
        if (hasPromo) {
            return PostSaleDto.builder()
                    .idUser(userId)
                    .date(LocalDate.now())
                    .category(1)
                    .price(100.0)
                    .product(createProductDto(productId))
                    .hasPromo(true)
                    .discount(10.0)
                    .build();
        } else {
            return PostDto.builder()
                    .userId(userId)
                    .date(LocalDate.now())
                    .category(1)
                    .price(100.0)
                    .product(createProductDto(productId))
                    .build();
        }
    }

    public static PostDto createPostDateDto(LocalDate date) {
        return PostDto.builder()
                .date(date)
                .build();
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
                    .product(new Product())
                    .category(1)
                    .price(100.0)
                    .hasPromo(false)
                    .discount(0.0)
                    .build());
            posts.add(Post.builder()
                    .id(posts.size() + 1)
                    .user(user)
                    .date(now.minusDays(cont + 20)) // Fuera de las últimas 2 semanas
                    .product(new Product())
                    .category(1)
                    .price(100.0)
                    .hasPromo(false)
                    .discount(0.0)
                    .build());
        }

        return posts;
    }

    public static List<PostDto> createListPostDtoForUser2Desc() {
        return List.of(
                PostFactory.createPostDateDto(LocalDate.of(2025, 2, 2)),
                PostFactory.createPostDateDto(LocalDate.of(2025, 1, 31)),
                PostFactory.createPostDateDto(LocalDate.of(2025, 1, 30)),
                PostFactory.createPostDateDto(LocalDate.of(2025, 1, 27)),
                PostFactory.createPostDateDto(LocalDate.of(2025, 1, 25))
        );
    }

    public static List<PostDto> createListPostDtoForUser2Asc() {
        return List.of(
                PostFactory.createPostDateDto(LocalDate.of(2025, 1, 25)),
                PostFactory.createPostDateDto(LocalDate.of(2025, 1, 27)),
                PostFactory.createPostDateDto(LocalDate.of(2025, 1, 30)),
                PostFactory.createPostDateDto(LocalDate.of(2025, 1, 31)),
                PostFactory.createPostDateDto(LocalDate.of(2025, 2, 2))
        );
    }

    public static List<Post> createListPostSale(User user) {
        return List.of(
                Post.builder()
                        .id(1)
                        .user(user)
                        .date(LocalDate.of(2025, 1, 19))
                        .product(new Product(201, "headphones", "Electronics", "Dell",
                                "Silver", "Includes charger and carrying case"))
                        .category(1)
                        .price(1200.00)
                        .hasPromo(true)
                        .discount(50.00)
                        .build(),

                Post.builder()
                        .id(2)
                        .user(user)
                        .date(LocalDate.of(2025, 1, 20))
                        .product(new Product(202, "Laptop", "Electronics", "Dell", "Silver",
                                "Includes charger and carrying case"))
                        .category(2)
                        .price(1200.00)
                        .hasPromo(true)
                        .discount(50.00)
                        .build(),

                Post.builder()
                        .id(3)
                        .user(user)
                        .date(LocalDate.of(2025, 1, 21))
                        .product(new Product(203, "chair", "Furniture", "Dell", "Silver",
                                "Includes charger and carrying case"))
                        .category(2)
                        .price(1200.00)
                        .hasPromo(true)
                        .discount(50.00)
                        .build()
        );
    }

    public static List<Post> createListPostWithPromo() {
        return List.of(
                Post.builder()
                        .id(4)
                        .user(new User(3, "Ciro Sánchez", true))
                        .date(LocalDate.of(2025, 1, 25))
                        .product(new Product(204, "Smartphone", "Electronics", "Apple",
                                "Black", "128GB storage, unlocked"))
                        .category(1)
                        .price(999.99)
                        .hasPromo(true)
                        .discount(null)
                        .build()
        );
    }
}
