package com.social_media.social_media.service;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.request.PostRequestDto;
import com.social_media.social_media.dto.request.ProductRequestDto;
import com.social_media.social_media.dto.response.PostResponseDto;
import com.social_media.social_media.dto.response.ProductResponseDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.Product;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.repository.user.UserRepositoryImpl;
import com.social_media.social_media.service.post.PostServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T0005 {

    @Mock
    PostRepositoryImpl postRepository;

    @Mock
    UserRepositoryImpl userRepository;

    @InjectMocks
    PostServiceImpl postService;

    @Test
    @DisplayName("T-0005 - Test of create post - Happy way")
    void createPostOk(){

        // 🟢 **Arrange**
        //entitys to mock
        User userToMock = TestUtils.createRandomUser();
        Product productMock = TestUtils.createRandomProduct();
        Post postMock = TestUtils.createRandomPostWithPostId(1L);

        ProductRequestDto productRequestDto = TestUtils.convertProductToRequestDto(productMock);
        ProductResponseDto productResponseDto = TestUtils.convertProductToResponseDto(productMock);

        PostResponseDto postResponseDtoExpected = TestUtils.convertPostToResponseDto(postMock, productResponseDto);
        PostRequestDto postRequestDto = TestUtils.convertPostToRequestDto(postMock, productRequestDto);
        
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userToMock));
        when(postRepository.add(any(Post.class))).thenReturn(postMock);

        // 🟡 **Act**
        PostResponseDto postResponseDtoActual = postService.createPost(postRequestDto);

        // 🔴 **Assert**
        //assertThat compara automáticamente todos los atributos de los objetos de forma recursiva, esto evita la necesidad de escribir múltiples assertEquals() manualmente.
        assertThat(postResponseDtoActual).usingRecursiveComparison().isEqualTo(postResponseDtoExpected);
    }

    @Test
    @DisplayName("T-0005 - Test of create post (User not found) - Sad way")
    void createPostNotOk() {
        // 🟢 **Arrange**
        PostRequestDto postRequestDto = TestUtils.createRandomPostRequestDto();

        //se simula que el id de usuario pasado no existe
        when(userRepository.findById(postRequestDto.getUser_id())).thenReturn(Optional.empty());

        // 🔴 **Act && Assert**
        assertThrows(NotFoundException.class,
                ()-> postService.createPost(postRequestDto)
        );

    }
}
