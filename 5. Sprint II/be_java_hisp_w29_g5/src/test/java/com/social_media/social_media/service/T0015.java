package com.social_media.social_media.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.response.FollowSuggestionResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.repository.follow.FollowRepositoryImpl;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.repository.user.UserRepositoryImpl;
import com.social_media.social_media.service.user.UserServiceImpl;
import com.social_media.social_media.utils.MessagesExceptions;

@ExtendWith(MockitoExtension.class)
public class T0015 {
    @Mock
    UserRepositoryImpl userRepository;

    @Mock
    PostRepositoryImpl postRepository;

    @Mock
    FollowRepositoryImpl followRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("T-0015 Follow Suggestions Test 200")
    void followSuggestionsTest200() {

        String brand = "NIKE";

        User userSeller = TestUtils.createRandomUser();
        User userSellerToSuggest = TestUtils.createRandomUser();
        Post postOne = TestUtils.createRandomPostWithBrand(userSeller.getUserId(), brand);
        Post postTwo = TestUtils.createRandomPostWithBrand(userSeller.getUserId(), brand);
        User user = TestUtils.createRandomUser();
        Follow follow = TestUtils.createFollow(user.getUserId(), userSeller.getUserId());

        List<Long> favoritesPostIds = List.of(
                postOne.getPostId(),
                postTwo.getPostId());

        List<String> favoriteBrands = List.of(brand);

        Map<Long, List<String>> sellersWithBrands = new HashMap<>();

        sellersWithBrands.put(userSeller.getUserId(), favoriteBrands);
        sellersWithBrands.put(userSellerToSuggest.getUserId(), favoriteBrands);

        when(userRepository.findById(user.getUserId()))
                .thenReturn(Optional.of(user));
        when(userRepository.findFavoritePostsById(user.getUserId())).thenReturn(favoritesPostIds);
        when(userRepository.findNameById(userSellerToSuggest.getUserId())).thenReturn(userSellerToSuggest.getName());

        when(postRepository.findById(postOne.getPostId())).thenReturn(Optional.of(postOne));
        when(postRepository.findById(postTwo.getPostId())).thenReturn(Optional.of(postTwo));
        when(postRepository.findSellersByBrands(favoriteBrands)).thenReturn(sellersWithBrands);

        when(followRepository.findFollowed(user.getUserId())).thenReturn(List.of(follow));

        List<FollowSuggestionResponseDto> expectedResponse = List.of(new FollowSuggestionResponseDto(
                userSellerToSuggest.getUserId(), userSellerToSuggest.getName(), favoriteBrands));
        List<FollowSuggestionResponseDto> actualResponse = userService.searchFollowSuggestions(user.getUserId(), 15);

        assertThat(actualResponse)
                .usingRecursiveComparison()
                .isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("T-0015 User not favorite post exception")
    void followSuggestionsFailNotFavoritePost() {

        User user = TestUtils.createRandomUser();

        when(userRepository.findById(user.getUserId()))
                .thenReturn(Optional.of(user));
        when(userRepository.findFavoritePostsById(user.getUserId())).thenReturn(List.of());

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> userService.searchFollowSuggestions(user.getUserId(), 15));
        String expectedMessage = MessagesExceptions.NO_FAVOURITE_POSTS;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0015 No Suggestions excception")
    void followSuggestionsFailNoSuggestions() {

        String brand = "NIKE";

        User userSeller = TestUtils.createRandomUser();
        Post postOne = TestUtils.createRandomPostWithBrand(userSeller.getUserId(), brand);
        Post postTwo = TestUtils.createRandomPostWithBrand(userSeller.getUserId(), brand);
        User user = TestUtils.createRandomUser();
        Follow follow = TestUtils.createFollow(user.getUserId(), userSeller.getUserId());

        List<Long> favoritesPostIds = List.of(
                postOne.getPostId(),
                postTwo.getPostId());

        List<String> favoriteBrands = List.of(brand);

        Map<Long, List<String>> sellersWithBrands = new HashMap<>();

        sellersWithBrands.put(userSeller.getUserId(), favoriteBrands);

        when(userRepository.findById(user.getUserId()))
                .thenReturn(Optional.of(user));
        when(userRepository.findFavoritePostsById(user.getUserId())).thenReturn(favoritesPostIds);

        when(postRepository.findById(postOne.getPostId())).thenReturn(Optional.of(postOne));
        when(postRepository.findById(postTwo.getPostId())).thenReturn(Optional.of(postTwo));
        when(postRepository.findSellersByBrands(favoriteBrands)).thenReturn(sellersWithBrands);

        when(followRepository.findFollowed(user.getUserId())).thenReturn(List.of(follow));

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> userService.searchFollowSuggestions(user.getUserId(), 15));
        String expectedMessage = MessagesExceptions.NO_SUGGESTIONS;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0015 User not found exception")
    void followSuggestionsFailUserNotFound() {
        User user = TestUtils.createRandomUser();

        when(userRepository.findById(user.getUserId()))
                .thenReturn(Optional.empty()); // Simulamos que el usuario no se encuentra

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> userService.searchFollowSuggestions(user.getUserId(), 15));

        String expectedMessage = MessagesExceptions.USER_NOT_FOUND;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
