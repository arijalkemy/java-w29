package com.social_media.social_media.service;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.BadRequestFollowException;
import com.social_media.social_media.repository.follow.FollowRepositoryImpl;
import com.social_media.social_media.repository.user.UserRepositoryImpl;
import com.social_media.social_media.service.user.UserServiceImpl;
import com.social_media.social_media.utils.MessagesExceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class T0007 {

    @Mock
    FollowRepositoryImpl followRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("T-0007 Unfollow Seller Test 200")
    void unfollowSellerTest200() {
        User user = TestUtils.createRandomUser();
        User userToUnfollow = TestUtils.createRandomUser();
        Follow follow = TestUtils.createFollow(user.getUserId(), userToUnfollow.getUserId());

        when(followRepository.existsByFollowerAndFollowed(user.getUserId(), userToUnfollow.getUserId()))
                .thenReturn(Optional.of(follow));

        doNothing().when(followRepository).deleteFollow(follow);


        userService.unfollowSeller(user.getUserId(), userToUnfollow.getUserId());


        when(followRepository.existsByFollowerAndFollowed(user.getUserId(), userToUnfollow.getUserId()))
                .thenReturn(Optional.empty());

        Optional<Follow> followCheck = followRepository.existsByFollowerAndFollowed(user.getUserId(), userToUnfollow.getUserId());
        assertEquals(Optional.empty(), followCheck);
    }

    @Test
    @DisplayName("T-0007 Unfollow Non-Existent User Throws Exception")
    void unfollowSellerTestFailUserNotFound() {
        User user = TestUtils.createRandomUser();
        User userToUnfollow = TestUtils.createRandomUser();

        when(followRepository.existsByFollowerAndFollowed(user.getUserId(), userToUnfollow.getUserId()))
                .thenReturn(Optional.empty());

        BadRequestFollowException thrown = assertThrows(
                BadRequestFollowException.class,
                () -> userService.unfollowSeller(user.getUserId(), userToUnfollow.getUserId())
        );

        String expectedMessage = MessagesExceptions.NOT_FOLLOW_ALREADY_EXISTS;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}