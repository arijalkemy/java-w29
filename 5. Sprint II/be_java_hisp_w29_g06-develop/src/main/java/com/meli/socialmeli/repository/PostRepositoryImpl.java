package com.meli.socialmeli.repository;

import com.meli.socialmeli.entity.Post;
import com.meli.socialmeli.entity.Product;
import com.meli.socialmeli.entity.Seller;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class PostRepositoryImpl implements IPostRepository {
    private List<Post> posts;

    public PostRepositoryImpl() {
        posts = new ArrayList<>();
    }

    @Override
    public Optional<Post> getById(Integer id) {
        return posts.stream().filter(post1 -> post1.getId() == id).findFirst();
    }

    @Override
    public List<Post> getPostsBySellers(List<Seller> sellers) {
        return sellers.stream()
                .flatMap(seller -> posts.stream()
                        .filter(post -> post.getSeller().getId().equals(seller.getId()))
                        .toList().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Post> save(Post post) {
        Optional<Post> postExist = this.getById(post.getId());

        if (postExist.isPresent()) {
            return Optional.empty();
        }

        post.setId(posts.size() + 1);
        posts.add(post);

        return Optional.of(post);
    }

    public Long getCountPostInSaleBySellerId(Integer user_id) {
        return posts.stream()
                    .filter(post -> (post.getSeller()
                                        .getId()
                                        .equals(user_id)
                                    &&
                                    post.getHasPromo()))
                    .count();
    }

    @Override
    public List<Post> getPostsInSaleBySellerId(Integer sellerId) {
        return this.posts.stream().filter(
                p -> p.getSeller().getId().equals(sellerId) && p.getHasPromo()
        ).toList();
    }

    @Override
    public List<Post> getPostsByPrice(Double minPrice, Double maxPrice) {
        return this.posts.stream().filter(
                p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice
        ).toList();
    }

    @Override
    public List<Post> getPostsByMinPrice(Double minPrice) {
        return this.posts.stream().filter(
                p -> p.getPrice() >= minPrice
        ).toList();
    }

    @Override
    public List<Post> getPostsByMaxPrice(Double maxPrice) {
        return this.posts.stream().filter(
                p -> p.getPrice() <= maxPrice
        ).toList();
    }
}
