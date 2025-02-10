package com.bootcamp.be_java_hisp_w29_g3.repository;

import com.bootcamp.be_java_hisp_w29_g3.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryImplTest {

    UserRepositoryImpl repository = new UserRepositoryImpl();


    @Test
    @DisplayName("US-0006 - Obtener los posts de las ultimas 2 semanas (T-0008)")
    void findPostsFromSellerByUserIdWithLimitDateOK(){
        //Arrange
        LocalDate limitDate = LocalDate.now().minusWeeks(2);

        //Act
        List<Post> posts = repository.findPostsFromSellerByUserIdWithLimitDate(1, limitDate);

        //Assert
        assertEquals(2, posts.size());
        assertEquals(1, posts.getFirst().getId());
        assertEquals(2, posts.getLast().getId());
    }

}