package com.social_media.social_media.service;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.response.FollowersCountResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.User;
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
public class T0002 {

    @Mock
    UserRepositoryImpl userRepository;

    @Mock
    PostRepositoryImpl postRepository;

    @Mock
    FollowRepositoryImpl followRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("T-0002 Count Followers Test 200")
    void countFollowersTest200() {
        User userFollower1 = TestUtils.createRandomUser();
        User userFollower2 = TestUtils.createRandomUser();
        User userFollower3 = TestUtils.createRandomUser();

        User userToFollow = TestUtils.createRandomUser();

        Post post = TestUtils.createRandomPost(userToFollow.getUserId());

        Follow follow = TestUtils.createFollow(userFollower1.getUserId(), userToFollow.getUserId());
        Follow follow2 = TestUtils.createFollow(userFollower2.getUserId(), userToFollow.getUserId());
        Follow follow3 = TestUtils.createFollow(userFollower3.getUserId(), userToFollow.getUserId());

        List<Follow> followers = List.of(follow, follow2, follow3);

        when(userRepository.findById(userToFollow.getUserId()))
                .thenReturn(Optional.of(userToFollow));

        when(postRepository.findPostBySellerId(userToFollow.getUserId()))
                .thenReturn(List.of(post));

        when(followRepository.findFollowers(userToFollow.getUserId()))
                .thenReturn(followers);

        FollowersCountResponseDto actualResponse = userService.searchFollowersCount(userToFollow.getUserId());

        FollowersCountResponseDto expectedResponse = TestUtils.convertFollowersToFollowersCountResponseDto(userToFollow, followers);

        assertEquals(expectedResponse, actualResponse);
        assertEquals(expectedResponse.getFollowers_count(), actualResponse.getFollowers_count());
    }

    @Test
    @DisplayName("T-0002 Followed user not found exception")
    void countFollowersTestFailUserNotFound() {
        User userToFollow = TestUtils.createRandomUser();

        when(userRepository.findById(userToFollow.getUserId()))
                .thenReturn(Optional.empty());

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> userService.searchFollowersCount(userToFollow.getUserId()));

        String expectedMessage = MessagesExceptions.SELLER_ID_NOT_EXIST;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0002 Followed user is not a seller exception")
    void countFollowersTestFailUserNotSeller() {
        User userToFollow = TestUtils.createRandomUser();

        when(userRepository.findById(userToFollow.getUserId()))
                .thenReturn(Optional.of(userToFollow));

        NotSellerException thrown = assertThrows(NotSellerException.class, () -> userService.searchFollowersCount(userToFollow.getUserId()));

        String expectedMessage = MessagesExceptions.FOLLOWED_USER_NOT_SELLER;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}
