package com.social_media.social_media.service;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.response.FollowingResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.BadRequestFollowException;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.repository.follow.FollowRepositoryImpl;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.repository.user.UserRepositoryImpl;
import com.social_media.social_media.service.user.UserServiceImpl;
import com.social_media.social_media.utils.MessagesExceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T0001 {

    @Mock
    UserRepositoryImpl userRepository;

    @Mock
    PostRepositoryImpl postRepository;

    @Mock
    FollowRepositoryImpl followRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("T-0001 Follow Seller Test 200")
    void followSellerTest200() {
        User user = TestUtils.createRandomUser();
        User userToFollow = TestUtils.createRandomUser();
        Post post = TestUtils.createRandomPost(userToFollow.getUserId());
        Follow follow = TestUtils.createFollow(user.getUserId(), userToFollow.getUserId());

        when(userRepository.findById(userToFollow.getUserId()))
                .thenReturn(Optional.of(userToFollow));

        when(userRepository.findById(user.getUserId()))
                .thenReturn(Optional.of(user));

        when(followRepository.existsByFollowerAndFollowed(
                user.getUserId(),
                userToFollow.getUserId()))
                .thenReturn(Optional.empty());

        when(postRepository.findByUserId(userToFollow.getUserId()))
                .thenReturn(List.of(post));

        when(followRepository.addFollow(user.getUserId(), userToFollow.getUserId()))
                .thenReturn(follow);


        FollowingResponseDto actualResponse = userService.followSeller(user.getUserId(), userToFollow.getUserId());

        FollowingResponseDto expectedResponse = TestUtils.convertFollowToResponseDto(follow);

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T-0001 Trying to follow oneself throws exception")
    void followSellerTestFailSelfFollow() {
        User user = TestUtils.createRandomUser();

        when(userRepository.findById(user.getUserId()))
                .thenReturn(Optional.of(user));

        BadRequestFollowException thrown = assertThrows(
                BadRequestFollowException.class,
                () -> userService.followSeller(user.getUserId(), user.getUserId())
        );

        String expectedMessage = MessagesExceptions.THE_USER_CANNOT_FOLLOW_THEMSELVES;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0001 Follow already exists exception")
    void followSellerTestFailAlreadyFollowing() {
        User user = TestUtils.createRandomUser();
        User userToFollow = TestUtils.createRandomUser();
        Follow follow = TestUtils.createFollow(user.getUserId(), userToFollow.getUserId());

        when(userRepository.findById(userToFollow.getUserId()))
                .thenReturn(Optional.of(userToFollow));

        when(userRepository.findById(user.getUserId()))
                .thenReturn(Optional.of(user));

        when(followRepository.existsByFollowerAndFollowed(
                user.getUserId(),
                userToFollow.getUserId()))
                .thenReturn(Optional.of(follow));

        BadRequestFollowException thrown = assertThrows(
                BadRequestFollowException.class,
                () -> userService.followSeller(user.getUserId(), userToFollow.getUserId())
        );

        String expectedMessage = MessagesExceptions.FOLLOW_ALREADY_EXISTS;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0001 Followed user is not a seller exception")
    void followSellerTestFailUserNotSeller() {
        User user = TestUtils.createRandomUser();
        User userToFollow = TestUtils.createRandomUser();

        when(userRepository.findById(userToFollow.getUserId()))
                .thenReturn(Optional.of(userToFollow));

        when(userRepository.findById(user.getUserId()))
                .thenReturn(Optional.of(user));

        when(followRepository.existsByFollowerAndFollowed(
                user.getUserId(),
                userToFollow.getUserId()))
                .thenReturn(Optional.empty());

        when(postRepository.findByUserId(userToFollow.getUserId()))
                .thenReturn(List.of());

        BadRequestFollowException thrown = assertThrows(
                BadRequestFollowException.class,
                () -> userService.followSeller(user.getUserId(), userToFollow.getUserId())
        );

        String expectedMessage = MessagesExceptions.FOLLOWED_USER_NOT_SELLER;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0001 Followed user not found exception")
    void followSellerTestFailUserNotFound() {
        User user = TestUtils.createRandomUser();
        User userToFollow = TestUtils.createRandomUser();

        when(userRepository.findById(userToFollow.getUserId()))
                .thenReturn(Optional.empty()); // Simulamos que el usuario no se encuentra

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> userService.followSeller(user.getUserId(), userToFollow.getUserId())
        );

        String expectedMessage = MessagesExceptions.USER_NOT_FOUND;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}