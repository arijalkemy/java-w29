package com.social_media.social_media.service;

import com.social_media.social_media.dto.request.PostPromoEndDateRequestDto;
import com.social_media.social_media.dto.request.PostPromoRequestDto;
import com.social_media.social_media.dto.response.PostPromoEndDateResponseDto;
import com.social_media.social_media.dto.response.PostPromoResponseDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.enums.PostType;
import com.social_media.social_media.exception.InvalidPromotionEndDateException;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class T0012 {
    @Mock
    UserRepositoryImpl userRepository;

    @Mock
    PostRepositoryImpl postRepository;

    @InjectMocks
    PostServiceImpl postService;

    @Test
    @DisplayName("T-0012 Create Post Promo With End Date Test 200")
    void createPostPromoEndDateTest200() {
        // Arrange
        User user = createRandomUser();
        Long idPostRandom = ThreadLocalRandom.current().nextLong(3L, 7L);
        Post postPromo = createRandomPostPromoWithPromotionEndDate(user.getUserId(), idPostRandom,
                LocalDate.of(2025, 1, 1), LocalDate.of(2025, 2, 2));
        PostPromoEndDateRequestDto postPromoEndDateRequest = convertPostPromoEndDateToRequestDto(postPromo);
        PostPromoEndDateResponseDto expectedResponse = convertPostPromoEndDateToResponseDto(postPromo);

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.findWithFilters(PostType.ALL, null)).thenReturn(createListRandomPosts(postPromo.getPostId().intValue() - 1));

        // Act
        PostPromoEndDateResponseDto actualResponse = postService.createPostPromoEndDate(postPromoEndDateRequest);

        // Assert
        verify(postRepository).add(postPromo);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T-0012 Create Post Promo With End Date Test 404 UserNotFound")
    void createPostPromoEndDateTestFailUserNotFound() {
        // Arrange
        Post postPromo = createRandomPost(anyLong());
        PostPromoEndDateRequestDto postPromoEndDateRequest = convertPostPromoEndDateToRequestDto(postPromo);

        when(userRepository.findById(postPromo.getUserId())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> postService.createPostPromoEndDate(postPromoEndDateRequest));
        verify(postRepository, never()).add(postPromo);
    }

    @Test
    @DisplayName("T-0012 Create Post Promo With End Date Test 400 End Date Before Publication Date")
    void createPostPromoEndDateTestFailEndDateBeforePublicationDate() {
        // Arrange
        Long idUserRandom = ThreadLocalRandom.current().nextLong(3L, 7L);
        Long idPostRandom = ThreadLocalRandom.current().nextLong(3L, 7L);
        Post postPromo = createRandomPostPromoWithPromotionEndDate(idUserRandom, idPostRandom, LocalDate.now(), LocalDate.of(2025, 1, 1));
        PostPromoEndDateRequestDto postPromoEndDateRequest = convertPostPromoEndDateToRequestDto(postPromo);

        // Act & Assert
        assertThrows(InvalidPromotionEndDateException.class, () -> postService.createPostPromoEndDate(postPromoEndDateRequest));
        verify(userRepository, never()).findById(postPromo.getUserId());
        verify(postRepository, never()).add(postPromo);
    }
}
