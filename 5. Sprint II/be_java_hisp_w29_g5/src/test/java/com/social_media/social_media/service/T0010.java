package com.social_media.social_media.service;

import com.social_media.social_media.dto.request.PostPromoRequestDto;
import com.social_media.social_media.dto.response.PostPromoResponseDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.enums.PostType;
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
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static com.social_media.social_media.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class T0010 {
    @Mock
    UserRepositoryImpl userRepository;

    @Mock
    PostRepositoryImpl postRepository;

    @InjectMocks
    PostServiceImpl postService;

    @Test
    @DisplayName("T-0010 Create Post Promo Test 200")
    void createPostPromoTest200() {
        // Arrange
        User user = createRandomUser();
        Long idPostRandom = ThreadLocalRandom.current().nextLong(3L, 7L);
        Post postPromo = createRandomPostPromoWithPromotionEndDate(user.getUserId(), idPostRandom, LocalDate.now(), null);
        PostPromoRequestDto postPromoRequest = convertPostPromoToRequestDto(postPromo);
        PostPromoResponseDto expectedResponse = convertPostPromoToResponseDto(postPromo);

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.findWithFilters(PostType.ALL, null)).thenReturn(createListRandomPosts(postPromo.getPostId().intValue() - 1));

        // Act
        PostPromoResponseDto actualResponse = postService.createPostPromo(postPromoRequest);

        // Assert
        verify(postRepository).add(postPromo);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T-0010 Create Post Promo Test 404 UserNotFound")
    void createPostPromoTestFailUserNotFound() {
        // Arrange
        Post postPromo = createRandomPost(anyLong());
        PostPromoRequestDto postPromoRequest = convertPostPromoToRequestDto(postPromo);

        when(userRepository.findById(postPromo.getUserId())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> postService.createPostPromo(postPromoRequest));
        verify(postRepository, never()).add(postPromo);
    }
}
