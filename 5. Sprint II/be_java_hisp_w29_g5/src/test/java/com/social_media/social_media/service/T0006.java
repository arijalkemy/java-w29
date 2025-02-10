package com.social_media.social_media.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.response.PostResponseDto;
import com.social_media.social_media.dto.response.ProductResponseDto;
import com.social_media.social_media.dto.response.SellersPostsByFollowerResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.Product;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.repository.follow.FollowRepositoryImpl;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.repository.user.UserRepositoryImpl;
import com.social_media.social_media.service.post.PostServiceImpl;
import com.social_media.social_media.utils.MessagesExceptions;

@ExtendWith(MockitoExtension.class)
public class T0006 {

    @Mock
    UserRepositoryImpl userRepository;

    @Mock
    PostRepositoryImpl postRepository;

    @Mock
    FollowRepositoryImpl followRepository;

    @InjectMocks
    PostServiceImpl postService;

    @Test
    @DisplayName("T-0006 Get followed post from last 2 weeks Test 200")
    void followedPostFromLastTwoWeeksTest200() {

        User user = TestUtils.createRandomUser();
        User sellerUser = TestUtils.createRandomUser();
        Post recentPost = TestUtils.createRandomPost(sellerUser.getUserId());
        Follow follow = TestUtils.createFollow(user.getUserId(), sellerUser.getUserId());

        Product product = recentPost.getProduct();
        ProductResponseDto productResponseDto = new ProductResponseDto(product.getProductId(), product.getProductName(),
                product.getType(), product.getBrand(), product.getColor(), product.getNotes());

        LocalDate lastTwoWeeks = LocalDate.now().minusWeeks(2);

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));

        when(followRepository.findFollowed(user.getUserId())).thenReturn(List.of(follow));

        when(postRepository.findByIdSince(sellerUser.getUserId(), lastTwoWeeks)).thenReturn(List.of(recentPost));

        List<PostResponseDto> postsDto = List.of(new PostResponseDto(recentPost.getPostId(), recentPost.getUserId(),
                recentPost.getDate(), productResponseDto, recentPost.getCategory(), recentPost.getPrice()));

        SellersPostsByFollowerResponseDto expectedResponse = new SellersPostsByFollowerResponseDto(
                user.getUserId(), postsDto);
        SellersPostsByFollowerResponseDto actualResponse = postService
                .searchFollowedPostsFromLastTwoWeeks(user.getUserId(), "date_asc");

        assertThat(actualResponse)
                .usingRecursiveComparison()
                .isEqualTo(expectedResponse);

    }

    @Test
    @DisplayName("T-0006 User not found exception")
    void followedPostFromLastTwoWeeksUserNotFound() {

        User user = TestUtils.createRandomUser();

        when(userRepository.findById(user.getUserId()))
                .thenReturn(Optional.empty());

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> postService.searchFollowedPostsFromLastTwoWeeks(user.getUserId(), "date_asc"));

        String expectedMessage = MessagesExceptions.USER_NOT_FOUND;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0006 Followeds not found exception")
    void followedPostFromLastTwoWeeksFollowedsNotFound() {

        User user = TestUtils.createRandomUser();

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));

        when(followRepository.findFollowed(user.getUserId())).thenReturn(List.of());

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> postService.searchFollowedPostsFromLastTwoWeeks(user.getUserId(), "date_asc"));

        String expectedMessage = MessagesExceptions.NO_FOLLOWERS_FOUND + user.getUserId();
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0006 Not Recent Post found exception")
    void followedPostFromLastTwoWeeksRecentPostsNotFound() {

        User user = TestUtils.createRandomUser();
        User sellerUser = TestUtils.createRandomUser();
        Follow follow = TestUtils.createFollow(user.getUserId(), sellerUser.getUserId());
        LocalDate lastTwoWeeks = LocalDate.now().minusWeeks(2);

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));

        when(followRepository.findFollowed(user.getUserId())).thenReturn(List.of(follow));

        when(postRepository.findByIdSince(sellerUser.getUserId(), lastTwoWeeks)).thenReturn(List.of());

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> postService.searchFollowedPostsFromLastTwoWeeks(user.getUserId(), "date_asc"));

        String expectedMessage = MessagesExceptions.NO_RECENT_POSTS_FOUND + user.getUserId();
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}
