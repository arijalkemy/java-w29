package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Post;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Product;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.CommonUser;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.Seller;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStorageImpl implements IMemoryStorageImpl{

    private static InMemoryStorageImpl instance;

    private final Map<Integer, User> usersById;
    private final Map<Integer, List<Post>> posts;

    private InMemoryStorageImpl(Map<Integer, User> usersById, Map<Integer, List<Post>> posts) {
        this.usersById = usersById;
        this.posts = posts;
    }

    public static InMemoryStorageImpl getInstance() {
        if (instance == null)
            instance = new InMemoryStorageImpl(generateSampleUsers(), generateSamplePosts());
        return instance;
    }

    @Override
    public Map<Integer, User> getUsersById() {
        return usersById;
    }

    @Override
    public Map<Integer, List<Post>> getPosts() {
        return posts;
    }

    // #------------------ LOAD METHODS ------------------#
    private static Map<Integer, User> generateSampleUsers() {
        Map<Integer, User> sampleUsers = new HashMap<>();

        // Crear vendedores
        Seller seller1 = new Seller("techStore");
        Seller seller2 = new Seller("sportsShop");
        Seller seller3 = new Seller("furnitureDealer");

        // Crear usuarios comunes
        CommonUser user1 = new CommonUser("john_doe");      //id4
        CommonUser user2 = new CommonUser("jane_smith");    //id5
        CommonUser user3 = new CommonUser("mike_wilson");   //id6

        // Configurar follows para vendedores
        seller1.setFollow(new ArrayList<>(List.of(4, 6)));
        seller2.setFollow(new ArrayList<>(List.of(5)));
        seller3.setFollow(new ArrayList<>(List.of(5, 6)));

        // Configurar follows para usuarios comunes
        user1.setFollow(new ArrayList<>(List.of(1)));
        user2.setFollow(new ArrayList<>(List.of(2, 3)));
        user3.setFollow(new ArrayList<>(List.of(1, 3)));


        // Agregar todos los usuarios al mapa
        sampleUsers.put(seller1.getUserId(), seller1);
        sampleUsers.put(seller2.getUserId(), seller2);
        sampleUsers.put(seller3.getUserId(), seller3);
        sampleUsers.put(user1.getUserId(), user1);
        sampleUsers.put(user2.getUserId(), user2);
        sampleUsers.put(user3.getUserId(), user3);

        return sampleUsers;
    }

    private static Map<Integer, List<Post>> generateSamplePosts() {
        Map<Integer, List<Post>> samplePosts = new HashMap<>();

        // Crear algunos productos de ejemplo
        Product product1 = new Product(1, "MacBook Pro", "Electronics", "Apple", "Space Gray", "Latest model");
        Product product2 = new Product(2, "Running Shoes", "Footwear", "Nike", "Black", "Perfect for marathon");
        Product product3 = new Product(3, "Gaming Chair", "Furniture", "DXRacer", "Red", "Ergonomic design");

        // Crear posts con los productos
        Post post1 = new Post(1, product1, LocalDate.now(), 100, 1299.99, true, 0.15);
        Post post2 = new Post(2, product2, LocalDate.now().minusDays(5), 200, 99.99);
        Post post3 = new Post(3, product3, LocalDate.now().minusDays(2), 300, 299.99, true, 0.10);

        samplePosts.put(post1.getUserId(), new ArrayList<>(List.of(post1)));
        samplePosts.put(post2.getUserId(), new ArrayList<>(List.of(post2)));
        samplePosts.put(post3.getUserId(), new ArrayList<>(List.of(post3)));

        return samplePosts;
    }

}
