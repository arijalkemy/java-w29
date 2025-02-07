package com.app.repository;

import com.app.model.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private IPostRepository postRepository;

    @Test
    @DisplayName("User with posts Example")
    void shouldHavePosts(){
        int userWithPostsId = 12003;
        List<Post> posts = postRepository.findPostsByUserId(userWithPostsId);

        assertFalse(posts.isEmpty());
    }

}
