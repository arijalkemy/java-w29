package com.social_media.social_media.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.request.PostPromoRequestDto;
import com.social_media.social_media.dto.response.PostPromoResponseDto;
import com.social_media.social_media.dto.response.UserFavoritesResponseDto;
import com.social_media.social_media.dto.response.UserWithFavoritesPostResponseDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.BadRequestFollowException;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.repository.user.UserRepositoryImpl;
import com.social_media.social_media.service.user.UserServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static com.social_media.social_media.TestUtils.*;
import static com.social_media.social_media.utils.MessagesExceptions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class T0013 {
    @Mock
    UserRepositoryImpl userRepository;

    @Mock
    PostRepositoryImpl postRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("T-0013 Search User Favorites Post Test 200")
    void searchUserFavoritesPostTest200() {
        // Arrange
        List<Post> favoritePosts = createListRandomPosts(5);
        List<Long> idFavoritePosts = favoritePosts.stream().mapToLong(Post::getPostId).boxed().toList();
        List<PostPromoResponseDto> favoritePostsDto = favoritePosts.stream()
                .map(TestUtils::convertPostPromoToResponseDto).toList();
        User user = createRandomUser();
        user.setFavoritePosts(idFavoritePosts);

        UserFavoritesResponseDto expectedResponse = UserFavoritesResponseDto.builder().favorites(favoritePostsDto)
                .build();

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findFavoritePostsById(user.getUserId())).thenReturn(idFavoritePosts);
        for (int i = 0; i < idFavoritePosts.size(); i++) {
            when(postRepository.findById(idFavoritePosts.get(i))).thenReturn(Optional.of(favoritePosts.get(i)));
        }

        // Act
        UserFavoritesResponseDto actualResponse = userService.searchUserFavoritesPost(user.getUserId());

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T-0013 Search User With 0 Favorites Post Test 200")
    void searchUserWith0FavoritesPostTest200() {
        // Arrange
        User user = createRandomUser();
        UserFavoritesResponseDto expectedResponse = UserFavoritesResponseDto.builder().favorites(List.of()).build();

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findFavoritePostsById(user.getUserId())).thenReturn(List.of());

        // Act
        UserFavoritesResponseDto actualResponse = userService.searchUserFavoritesPost(user.getUserId());

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T-0013 Search User Favorites Post Test 404 UserNotFound")
    void searchUserFavoritesPostTestFailUserNotFound() {
        // Arrange
        Long randomUserId = anyLong();
        when(userRepository.findById(randomUserId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> userService.searchUserFavoritesPost(randomUserId));
        verify(userRepository, never()).findFavoritePostsById(randomUserId);
        verify(postRepository, never()).findById(anyLong());
    }

    @Test
    @DisplayName("T-0013 Update User Favorites Post Test 200")
    void updateUserFavoritesPostTest200() {
        // Arrange
        List<Post> favoritePosts = createListRandomPosts(5);
        List<Long> idFavoritePosts = favoritePosts.stream().mapToLong(Post::getPostId).boxed().toList();
        User user = createRandomUserWithFavorites(idFavoritePosts);
        Post post = createRandomPost(anyLong());

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.findById(post.getPostId())).thenReturn(Optional.of(post));
        when(userRepository.findFavoritePostsById(user.getUserId())).thenReturn(idFavoritePosts);

        List<Post> favoritePostsUpdated = Stream.concat(favoritePosts.stream(), Stream.of(post)).toList();
        List<Long> idFavoritePostsUpdated = Stream.concat(idFavoritePosts.stream(), Stream.of(post.getPostId()))
                .toList();
        User userUpdated = User.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .favoritePosts(idFavoritePostsUpdated)
                .build();
        when(userRepository.update(user.getUserId(), post.getPostId())).thenReturn(userUpdated);
        for (int i = 0; i < idFavoritePostsUpdated.size(); i++) {
            when(postRepository.findById(idFavoritePostsUpdated.get(i)))
                    .thenReturn(Optional.of(favoritePostsUpdated.get(i)));
        }
        UserWithFavoritesPostResponseDto expectedResponse = UserWithFavoritesPostResponseDto.builder()
                .user_id(user.getUserId())
                .user_name(user.getName())
                .favorite_posts(favoritePostsUpdated)
                .build();

        // Act
        UserWithFavoritesPostResponseDto actualResponse = userService.updateUserFavoritesPost(user.getUserId(),
                post.getPostId());

        // Assert
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .isEqualTo(expectedResponse);
        verify(userRepository).update(user.getUserId(), post.getPostId());
    }

    @Test
    @DisplayName("T-0013 Update User Favorites Post Test 404 UserNotFound")
    void updateUserFavoritesPostTestFailUserNotFound() {
        // Arrange
        Long randomUserId = anyLong();
        Long randomPostId = ThreadLocalRandom.current().nextLong(3L, 7L);
        when(userRepository.findById(randomUserId)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException thrown = assertThrows(NotFoundException.class,
                () -> userService.updateUserFavoritesPost(randomUserId, randomPostId));
        assertEquals(USER_NOT_FOUND, thrown.getMessage());
        verify(postRepository, never()).findById(randomPostId);
        verify(userRepository, never()).findFavoritePostsById(randomUserId);
        verify(userRepository, never()).update(randomUserId, randomPostId);
    }

    @Test
    @DisplayName("T-0013 Update User Favorites Post Test 404 PostNotFound")
    void updateUserFavoritesPostTestFailPostNotFound() {
        // Arrange
        User user = createRandomUser();
        Long randomPostId = anyLong();
        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.findById(randomPostId)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException thrown = assertThrows(NotFoundException.class,
                () -> userService.updateUserFavoritesPost(user.getUserId(), randomPostId));
        assertEquals(POST_NOT_FOUND, thrown.getMessage());
        verify(userRepository, never()).findFavoritePostsById(user.getUserId());
        verify(userRepository, never()).update(user.getUserId(), randomPostId);
    }

    @Test
    @DisplayName("T-0013 Update User Favorites Post Test 400 PostAlreadyFavorite")
    void updateUserFavoritesPostTestFailPostAlreadyFavorite() {
        // Arrange
        User user = createRandomUser();
        Post post = createRandomPost(anyLong());
        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.findById(post.getPostId())).thenReturn(Optional.of(post));
        when(userRepository.findFavoritePostsById(user.getUserId())).thenReturn(List.of(post.getPostId()));

        // Act & Assert
        BadRequestFollowException thrown = assertThrows(BadRequestFollowException.class,
                () -> userService.updateUserFavoritesPost(user.getUserId(), post.getPostId()));
        assertEquals(POST_ALREADY_FAVORITE, thrown.getMessage());
        verify(userRepository, never()).update(user.getUserId(), post.getPostId());
    }
}
