package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.entity.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Repository
public class PostRepositoryImpl implements IPostRepository {
    List<Post> posts;

    public PostRepositoryImpl(){
        posts = new ArrayList<>(List.of(
                new Post(1L, 1L, LocalDate.now().minusDays(5), 1L, 1, 1200.00, true, 200.00),
                new Post(2L, 2L, LocalDate.now().minusDays(10), 2L, 1, 999.99, true, 0.00),
                new Post(3L, 1L, LocalDate.now().minusDays(20), 3L, 1, 1500.50, true, 300.50),
                new Post(4L, 4L, LocalDate.now().minusDays(3), 4L, 3, 19.99, true, 5.00),
                new Post(5L, 5L, LocalDate.now().minusDays(3), 5L, 3, 89.99, false, 0.00),
                new Post(6L, 6L, LocalDate.now().minusDays(3), 6L, 4, 199.99, true, 50.00),
                new Post(7L, 7L, LocalDate.now().minusDays(3), 7L, 1, 299.99, false, 0.00),
                new Post(8L, 8L, LocalDate.now().minusDays(3), 8L, 5, 149.99, true, 20.00),
                new Post(9L, 9L, LocalDate.now().minusDays(3), 9L, 4, 79.99, true, 15.00),
                new Post(10L, 10L, LocalDate.now().minusDays(3), 10L, 5, 199.99, false, 0.00)
        ));

    }

    @Override
    public Optional<Post> getById(Long id) {
        //Revisar si mejor dejamos == o con equals es mejor?
        return posts.stream().filter(post -> post.getPost_id().equals(id)).findFirst();
    }

    @Override
    public Post save(Post newPost) {
         posts.add(newPost);
         return newPost;
    }

    @Override
    public Boolean delete(Post post) {
        posts.remove(post);
        return true;
    }

    @Override
    public List<Post> getPromoPostBySellerID(Long userId) {
        return posts.stream().filter(post -> post.getUser_id().equals(userId) && post.getHas_promo()).collect(Collectors.toList());
    }

    @Override
    public List<Post> getAll(Long sellerId, Boolean hasPromo, Integer category) {
        Predicate<Post> predicate = post -> true;

        if(sellerId != null){
            predicate = predicate.and(post -> Objects.equals(post.getUser_id(), sellerId));
        }
        if(hasPromo != null){
            predicate = predicate.and(post -> post.getHas_promo() == hasPromo);
        }

        if(category != null){
            predicate = predicate.and(post -> Objects.equals(post.getCategory(), category));
        }

        return posts.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostsBySellerID(Long sellerId) {
        return posts.stream().filter(post -> post.getUser_id().equals(sellerId)).collect(Collectors.toList());
    }
}
