package com.bootcamp.be_java_hisp_w29_g3.repository;

import com.bootcamp.be_java_hisp_w29_g3.entity.Post;
import com.bootcamp.be_java_hisp_w29_g3.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    private final List<Post> listOfPosts = new ArrayList<>();

    public PostRepositoryImpl(){
        loadDB();
    }

    private void loadDB(){
        Product product1 = new Product(1, "Laptop Dell", "Electrónica", "Dell", "Negro", "Laptop de alta gama");
        Product product2 = new Product(2, "Smartphone Samsung", "Electrónica", "Samsung", "Azul", "Smartphone con excelente cámara");
        Product product3 = new Product(3, "Camisa Nike", "Ropa", "Nike", "Blanco", "Camisa deportiva");
        Product product4 = new Product(4, "Zapatos Adidas", "Ropa", "Adidas", "Rojo", "Zapatos cómodos para deporte");

        // Crear posts de prueba para vendedores
        List<Post> posts = List.of(
                new Post(1, LocalDate.of(2025, 1, 21), product1, 1, 1000.0, true, 10.0),
                new Post(2, LocalDate.of(2025, 1, 5), product2, 2, 600.0, false, 0.0),
                new Post(3, LocalDate.of(2025, 1, 22), product3, 3, 30.0, true, 5.0),
                new Post(4, LocalDate.of(2025, 1, 23), product4, 3, 50.0, false, 0.0),
                new Post(5, LocalDate.of(2025, 1, 24), product1, 3, 50.0, false, 0.0)
        );

        listOfPosts.addAll(posts);
    }
    @Override
    public List<Post> findAll() {
        return listOfPosts;
    }

    @Override
    public void addPost(Post post) {
        listOfPosts.add(post);
    }

    @Override
    public List<Post> filterPostsByDiscountRange(Integer initialValue, Integer finalValue) {
        return  listOfPosts.stream()
                .filter(post -> post.getHasProm() && post.getDiscount() >= initialValue && post.getDiscount() <= finalValue)
                .toList();
    }
}
