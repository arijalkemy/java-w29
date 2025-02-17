package com.social_media.social_media.service;


import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.response.FollowersResponseDto;
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
public class T0003 {
    @Mock
    private UserRepositoryImpl userRepository;

    @Mock
    private FollowRepositoryImpl  followRepository;

    @Mock
    private PostRepositoryImpl postRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("T-0003 search a list of all user that follows a seller")
    void searchFollowers() {
        User userFollowed = TestUtils.createRandomUser();
        User userFollower = TestUtils.createRandomUser();

        Post post = TestUtils.createRandomPost(userFollowed.getUserId());
        Follow followSeller = TestUtils.createFollow(userFollowed.getUserId(),userFollower.getUserId());

        //arrange
        when(userRepository.findById(userFollowed.getUserId()))
                .thenReturn(Optional.of(userFollowed));

        when(followRepository.findFollowers(userFollowed.getUserId()))
                .thenReturn(List.of(followSeller));

        when(postRepository.findPostBySellerId(userFollowed.getUserId()))
                .thenReturn(List.of(post));

        //act
        FollowersResponseDto followersResponseDto = userService.searchFollowers(userFollowed.getUserId(), "name_asc");

        //assert
        assertEquals(followersResponseDto.getUser_id(),userFollowed.getUserId());
        assertEquals(followersResponseDto.getUser_name(),userFollowed.getName());
        assertEquals(followersResponseDto.getFollowers().size(),1);
    }

    @Test
    @DisplayName("T0003 ")
    void searchFollowersThatUserNotFound(){
        User userFollowed = TestUtils.createRandomUser();

        when(userRepository.findById(userFollowed.getUserId()))
                .thenReturn(Optional.empty());

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> userService.searchFollowers(userFollowed.getUserId(), "name_asc")
        );

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
                () -> userService.searchFollowers(userFollowed.getUserId(), "name_asc")
        );

        assertEquals(MessagesExceptions.FOLLOWED_USER_NOT_SELLER, thrown.getMessage());
    }
}
