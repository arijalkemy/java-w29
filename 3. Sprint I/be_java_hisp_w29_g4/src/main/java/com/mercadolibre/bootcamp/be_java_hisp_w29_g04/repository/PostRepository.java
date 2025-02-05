package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Post;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements  IPostRepository{

    private final InMemoryStorageImpl memoryStorage;

    public PostRepository() {
        this.memoryStorage = InMemoryStorageImpl.getInstance();
    }


    @Override
    public List<Post> getUserPosts(Integer userId) {
        return memoryStorage.getPosts().get(userId);
    }

    @Override
    public List<Post> getPromoPostsBySellerId(Integer seller_id) {
        return memoryStorage.getPosts()
                .get(seller_id)
                .stream()
                .filter(post -> post.getHasPromo() && post.getUserId().equals(seller_id))
                .collect(Collectors.toList());
    }

    // #------------------ CRUD METHODS ------------------#
    @Override
    public List<Post> findAll() {
        return memoryStorage
                .getPosts()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Post> findById(Integer id) {
        return memoryStorage.getPosts().values()
                .stream()
                .flatMap(Collection::stream)
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Post> save(Post post) {
        List<Post> p = memoryStorage.getPosts().getOrDefault(post.getUserId(), new ArrayList<>());
        p.add(post);

        memoryStorage.getPosts().putIfAbsent(post.getUserId(), p);

        return Optional.of(post);
    }

    @Override
    public boolean delete(Integer postId) {
        return memoryStorage.getPosts().values().stream()
                .flatMap(List::stream)
                .filter(post -> post.getId().equals(postId))
                .findFirst()
                .map(post -> {
                    memoryStorage.getPosts().get(post.getUserId()).remove(post);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public Optional<Post> update(Post t) {
        List<Post> postsOfUser = memoryStorage.getPosts().getOrDefault(t.getUserId(), new ArrayList<>());

        Post replaced = null;
        for (int i = 0; i < memoryStorage.getPosts().size() && replaced == null; i++) {
            Post p = postsOfUser.get(i);
            if (p.getId().equals(t.getId())) {
                postsOfUser.add(i, t);
                replaced = p;
            }
        }
        return Optional.ofNullable(replaced);
    }


}
