package com.thiagoschreck.local.melisocial.repository;

import com.thiagoschreck.local.melisocial.entity.product.Post;
import com.thiagoschreck.local.melisocial.entity.product.Product;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class PostsRepositoryTests {
    private final IPostsRepository postsRepository = new PostsRepositoryImpl();


    @Test
    void getAllPostsFromSellersWithinWeeksAgoOkTest() {
        //Arrange
        Seller seller = new Seller("Pepe");
        seller.setUserId(1);

        LocalDate now = LocalDate.now();
        Product product1 = new Product(1,"Motocicleta", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1,  seller.getUserId(), now, product1, 1, 40.0, false, 8.0);
        postsRepository.save(post1);

        LocalDate dayAgo = now.minusDays(1);
        Product product2 = new Product(2,"Pepito", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post2 = new Post(2,  seller.getUserId(), dayAgo, product2, 1, 80.0, false, 6.0);
        postsRepository.save(post2);

        LocalDate weekAgo = now.minusWeeks(1);
        Product product3 = new Product(3,"Coche", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");

        Post post3 = new Post(3, seller.getUserId(), weekAgo, product3, 1, 80.0, false, 6.0);
        postsRepository.save(post3);

        LocalDate weeks3Ago = LocalDate.now().minusWeeks(3);

        Product product4 = new Product(4,"Bicicleta", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post4 = new Post(4,  seller.getUserId(), weeks3Ago, product4, 1, 40.0, false, 8.0);
        postsRepository.save(post4);

        //Act
        List<Post> actual = postsRepository.getAllPostFromSellersWithinWeeksAgo(seller.getUserId(), LocalDate.now().minusWeeks(2));

            List<Post> expected = List.of(
                post1,
                post2,
                post3
        );

        //Assert
        assertEquals(actual, expected);
    }


    @Test
    @DisplayName("Test that if you make only posts that are from more than two weeks ago, the it returns an empty list")
    void getAllPostsFromSellersWithinWeeksMoreThatTwoWeeksAgo() {
        //Arrange
        Seller seller = new Seller("Pepe");
        seller.setUserId(1);

        LocalDate threeWeeksAgo = LocalDate.now().minusWeeks(3);
        Product product1 = new Product(1,"Motocicleta", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1,  seller.getUserId(), threeWeeksAgo, product1, 1, 40.0, false, 8.0);
        postsRepository.save(post1);

        Product product2 = new Product(2,"Pepito", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post2 = new Post(2,  seller.getUserId(), threeWeeksAgo, product2, 1, 80.0, false, 6.0);
        postsRepository.save(post2);

        Product product3 = new Product(3,"Coche", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");

        Post post3 = new Post(3, seller.getUserId(), threeWeeksAgo, product3, 1, 80.0, false, 6.0);
        postsRepository.save(post3);


        Product product4 = new Product(4,"Bicicleta", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post4 = new Post(4,  seller.getUserId(), threeWeeksAgo, product4, 1, 40.0, false, 8.0);
        postsRepository.save(post4);

        //Act
        List<Post> actual = postsRepository.getAllPostFromSellersWithinWeeksAgo(seller.getUserId(), LocalDate.now().minusWeeks(2));

        List<Post> expected = Collections.emptyList();

        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void getAllPostsFromSellersWithinWeeksAgoOrderAscOkTest() {
        //Arrange
        Seller seller = new Seller("Pepe");
        seller.setUserId(1);

        LocalDate now = LocalDate.now();
        Product product1 = new Product(1,"Motocicleta", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1,  seller.getUserId(), now, product1, 1, 40.0, false, 8.0);
        postsRepository.save(post1);

        LocalDate twoDaysAgo = LocalDate.now().minusDays(2);

        Product product4 = new Product(4,"Bicicleta", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post4 = new Post(4,  seller.getUserId(), twoDaysAgo, product4, 1, 40.0, false, 8.0);
        postsRepository.save(post4);

        LocalDate dayAgo = now.minusDays(1);
        Product product2 = new Product(2,"Pepito", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post2 = new Post(2,  seller.getUserId(), dayAgo, product2, 1, 80.0, false, 6.0);
        postsRepository.save(post2);

        LocalDate weekAgo = now.minusWeeks(1);
        Product product3 = new Product(3,"Coche", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");

        Post post3 = new Post(3, seller.getUserId(), weekAgo, product3, 1, 80.0, false, 6.0);
        postsRepository.save(post3);


        //Act
        Stream<Post> streamActual = postsRepository.getAllPostFromSellersWithinWeeksAgoOrderAsc(seller.getUserId(), LocalDate.now().minusWeeks(2));

        Stream<Post> streamExpected = Stream.of(
               post3,
                post4,
                post2,
                post1
        );

        List<Post> actual = streamActual.toList();
        List<Post> expected = streamExpected.toList();

        //Assert
        assertIterableEquals(actual, expected);
    }
}
