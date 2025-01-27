package com.thiagoschreck.local.melisocial.repository;

import com.thiagoschreck.local.melisocial.entity.product.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class PostsRepositoryImpl implements IPostsRepository {
    private Integer identity = 0;
    private final Map<Integer, Post> posts;

    public PostsRepositoryImpl() {
        posts = new HashMap<>();
    }

    @Override
    public List<Post> getAllPromoPostsFromSeller(Integer sellerId) {
        return getAllPostsFromSeller(sellerId).stream()
                .filter(Post::isOnPromotion)
                .toList();
    }

    @Override
    public long getPromoPostsCountFromSeller(Integer sellerId) {
        return getAllPostsFromSeller(sellerId).stream().filter(Post::isOnPromotion).count();
    }

    @Override
    public Integer getIdentity() {
        return identity;
    }

    @Override
    public Post save(Post post) {
        this.posts.put(identity++, post);
        return post;
    }

    @Override
    public List<Post> getAllPostFromSellersWithinWeeksAgo(Integer sellerId, LocalDate weeksAgo) {
        return getAllPostsFromSeller(sellerId).stream()
                .filter(post -> post.getDate().isAfter(weeksAgo) || post.getDate().equals(weeksAgo))
                .toList();
    }

    @Override
    public Stream<Post> getAllPostFromSellersWithinWeeksAgoOrderAsc(Integer sellerId, LocalDate weeksAgo) {
        return getAllPostFromSellersWithinWeeksAgo(sellerId, weeksAgo)
                .stream()
                .sorted(Comparator.comparing(Post::getDate).thenComparing(Post::getId));

    }


    private List<Post> getAllPostsFromSeller(Integer sellerId) {
        return posts.values().stream().filter(post -> post.getUserId().equals(sellerId)).toList();
    }
}
