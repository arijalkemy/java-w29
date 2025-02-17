package com.social_media.social_media.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.response.FollowersResponseDto;
import com.social_media.social_media.dto.response.UserResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.InvalidOrderException;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.exception.NotSellerException;
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
public class T0008 {
        @Mock
        UserRepositoryImpl userRepository;

        @Mock
        PostRepositoryImpl postRepository;

        @Mock
        FollowRepositoryImpl followRepository;

        @InjectMocks
        UserServiceImpl userService;

        @Test
        @DisplayName("T-0008 Search followers successfully with ascending order")
        void searchFollowersSuccessAsc() {
                User userFollowed = TestUtils.createRandomUser();

                userFollowed.setUserId(99L);

                Post post = TestUtils.createRandomPost(userFollowed.getUserId());

                List<User> userFollowers = TestUtils.createTenRandomUsers();

                List<Follow> followers = TestUtils.createTenFollowersForUser(userFollowed.getUserId(), userFollowers,
                                true);

                when(userRepository.findById(userFollowed.getUserId()))
                                .thenReturn(Optional.of(userFollowed));

                when(postRepository.findPostBySellerId(userFollowed.getUserId()))
                                .thenReturn(List.of(post));

                when(followRepository.findFollowers(userFollowed.getUserId()))
                                .thenReturn(followers);

                for (Follow follower : followers) {
                        when(userRepository.findById(follower.getFollowerId()))
                                        .thenReturn(Optional.of(
                                                        userFollowers
                                                                        .stream()
                                                                        .filter(u -> u.getUserId()
                                                                                        .equals(follower.getFollowerId()))
                                                                        .findFirst().get()));
                }

                FollowersResponseDto response = userService.searchFollowers(userFollowed.getUserId(), "name_asc");

                FollowersResponseDto expectedResponse = TestUtils.convertFollowersToResponseDto(userFollowed,
                                userFollowers);

                assertEquals(expectedResponse.getUser_name(), response.getUser_name());
                assertEquals(expectedResponse.getUser_id(), response.getUser_id());

                for (int i = 0; i < response.getFollowers().size(); i++) {
                        UserResponseDto actualUser = response.getFollowers().get(i);
                        UserResponseDto expectedUser = expectedResponse.getFollowers().get(i);

                        assertThat(actualUser)
                                        .usingRecursiveComparison()
                                        .isEqualTo(expectedUser);
                }

        }

        @Test
        @DisplayName("T-0008 Search followers successfully with descending order")
        void searchFollowersSuccessDesc() {
                User userFollowed = TestUtils.createRandomUser();

                Post post = TestUtils.createRandomPost(userFollowed.getUserId());

                List<User> userFollowers = TestUtils.createTenRandomUsers();

                List<Follow> followers = TestUtils.createTenFollowersForUser(userFollowed.getUserId(), userFollowers,
                                false);

                when(userRepository.findById(userFollowed.getUserId()))
                                .thenReturn(Optional.of(userFollowed));

                when(postRepository.findPostBySellerId(userFollowed.getUserId()))
                                .thenReturn(List.of(post));

                when(followRepository.findFollowers(userFollowed.getUserId()))
                                .thenReturn(followers);

                for (Follow follower : followers) {
                        when(userRepository.findById(follower.getFollowerId()))
                                        .thenReturn(Optional.of(
                                                        userFollowers
                                                                        .stream()
                                                                        .filter(u -> u.getUserId()
                                                                                        .equals(follower.getFollowerId()))
                                                                        .findFirst().get()));
                }

                FollowersResponseDto response = userService.searchFollowers(userFollowed.getUserId(), "name_desc");

                FollowersResponseDto expectedResponse = TestUtils.convertFollowersToResponseDto(userFollowed,
                                userFollowers);

                assertEquals(expectedResponse.getUser_name(), response.getUser_name());
                assertEquals(expectedResponse.getUser_id(), response.getUser_id());

                for (int i = 0; i < response.getFollowers().size(); i++) {
                        UserResponseDto actualUser = response.getFollowers().get(i);
                        UserResponseDto expectedUser = expectedResponse.getFollowers().get(i);

                        assertThat(actualUser)
                                        .usingRecursiveComparison()
                                        .isEqualTo(expectedUser);
                }

        }

        @Test
        @DisplayName("T-0008 Search followers fail user not found")
        void searchFollowersFailUserNotFound() {
                User userFollowed = TestUtils.createRandomUser();

                when(userRepository.findById(userFollowed.getUserId()))
                                .thenReturn(Optional.empty());

                NotFoundException thrown = assertThrows(
                                NotFoundException.class,
                                () -> userService.searchFollowers(userFollowed.getUserId(), "name_asc"));

                assertEquals(MessagesExceptions.USER_NOT_FOUND, thrown.getMessage());
        }

        @Test
        @DisplayName("T-0008 Search followers user is not a seller")
        void searchFollowersFailUserNotSeller() {
                User userFollowed = TestUtils.createRandomUser();

                when(userRepository.findById(userFollowed.getUserId()))
                                .thenReturn(Optional.of(userFollowed));

                when(postRepository.findPostBySellerId(userFollowed.getUserId()))
                                .thenReturn(List.of());

                NotSellerException thrown = assertThrows(
                                NotSellerException.class,
                                () -> userService.searchFollowers(userFollowed.getUserId(), "name_asc"));

                assertEquals(MessagesExceptions.FOLLOWED_USER_NOT_SELLER, thrown.getMessage());
        }

        @Test
        @DisplayName("T-0008 Search followers with invalid order")
        void searchFollowersFailInvalidOrder() {
                User userFollowed = TestUtils.createRandomUser();
                Post post = TestUtils.createRandomPost(userFollowed.getUserId());

                when(userRepository.findById(userFollowed.getUserId()))
                                .thenReturn(Optional.of(userFollowed));

                when(postRepository.findPostBySellerId(userFollowed.getUserId()))
                                .thenReturn(List.of(post));

                InvalidOrderException thrown = assertThrows(
                                InvalidOrderException.class,
                                () -> userService.searchFollowers(userFollowed.getUserId(), "invalid_order"));

                assertEquals(MessagesExceptions.INVALID_ORDER, thrown.getMessage());
        }

}
