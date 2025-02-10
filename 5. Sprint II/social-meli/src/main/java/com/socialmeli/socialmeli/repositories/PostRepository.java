package com.socialmeli.socialmeli.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Getter
public class PostRepository implements IPostRepository {

    private List<Post> posts = new ArrayList<>();

    @PostConstruct
    public void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        file = ResourceUtils.getFile("classpath:posts.json");
        this.posts = objectMapper.readValue(file, new TypeReference<>() { });
    }

    @Override
    public void save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
    }

    @Override
    public Boolean existsProductById(Integer id) {
        return posts.stream().anyMatch(p -> p.getProduct().getId().equals(id));
    }

    @Override
    public List<Post> postFromUsers(List<User> userList) {
        return posts.stream().filter(post -> userList.contains(post.getUser())).toList();
    }

    @Override
    public List<Post> findPostsWithPromoByUser(Integer userId) {
        return posts.stream().filter(post -> post.getHasPromo()
                && post.getUser().getId().equals(userId)).collect(Collectors.toList());
    }
}
