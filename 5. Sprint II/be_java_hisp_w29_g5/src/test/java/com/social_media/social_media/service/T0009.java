package com.social_media.social_media.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.social_media.social_media.dto.response.PostResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.service.post.PostServiceImpl;
import com.social_media.social_media.dto.response.SellersPostsByFollowerResponseDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.repository.follow.IFollowRepository;
import com.social_media.social_media.repository.post.IPostRepository;
import com.social_media.social_media.repository.user.IUserRepository;
import com.social_media.social_media.TestUtils;
import com.social_media.social_media.utils.MessagesExceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class T0009 {
    @Mock
    private IPostRepository postRepository;
    @Mock
    private IUserRepository userRepository;
    @Mock
    private IFollowRepository followRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    @DisplayName("T-0005: Verify that a valid sorting allows to continue normally (US-0009)")
    public void searchFollowedPostsTestSuccessWithValidOrder() {
        Long userId = 1L;
        List<Post> mockedPosts = List.of(TestUtils.createRandomPost(userId));

        when(userRepository.findById(userId)).thenReturn(Optional.of(TestUtils.createRandomUser()));
        when(followRepository.findFollowed(userId)).thenReturn(List.of(TestUtils.createFollow(userId, userId)));
        when(postRepository.findByIdSince(userId, LocalDate.now().minusWeeks(2))).thenReturn(mockedPosts);

        SellersPostsByFollowerResponseDto response = postService.searchFollowedPostsFromLastTwoWeeks(userId, "date_asc");

        assertEquals(response.getPosts().size(), mockedPosts.size());
    }

    @Test
    @DisplayName("T-0005: Verify that an exception is thrown when no followers are found for the user (US-0009)")
    public void searchFollowedPostsTestFailWithInvalidOrder() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.of(TestUtils.createRandomUser()));

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> postService.searchFollowedPostsFromLastTwoWeeks(userId, "invalid_order")
        );

        assertEquals(MessagesExceptions.NO_FOLLOWERS_FOUND + userId, exception.getMessage());
    }

    @Test
    @DisplayName("T-0006: Verify the correct ascending sorting by date (US-0009)")
    public void searchFollowedPostsTestSuccessWithAscendingOrder() {
        Long userId = 1L;


        Post post1 = TestUtils.createRandomPost(userId);
        post1.setDate(LocalDate.of(2023, 1, 1));

        Post post2 = TestUtils.createRandomPost(userId);
        post2.setDate(LocalDate.of(2023, 1, 3));
        Post post3 = TestUtils.createRandomPost(userId);
        post3.setDate(LocalDate.of(2023, 1, 2));

        List<Post> mockedPosts = List.of(post2, post3, post1);

        when(userRepository.findById(userId)).thenReturn(Optional.of(TestUtils.createRandomUser()));

        when(followRepository.findFollowed(userId)).thenReturn(List.of(
                new Follow(userId, 2L)
        ));

        when(postRepository.findByIdSince(anyLong(), any(LocalDate.class))).thenReturn(mockedPosts);

        SellersPostsByFollowerResponseDto response = postService.searchFollowedPostsFromLastTwoWeeks(userId, "date_asc");

        List<LocalDate> dates = response.getPosts().stream().map(PostResponseDto::getDate).toList();

        System.out.println(dates);

        assertEquals(List.of(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 1, 2),
                LocalDate.of(2023, 1, 3)
        ), dates);
    }

    @Test
    @DisplayName("T-0006: Verify the correct descending sorting by date (US-0009)")
    public void searchFollowedPostsTestSuccessWithDescendingOrder() {
        Long userId = 1L;

        Post post1 = TestUtils.createRandomPost(userId);
        post1.setDate(LocalDate.of(2024, 1, 1));
        Post post2 = TestUtils.createRandomPost(userId);
        post2.setDate(LocalDate.of(2024, 1, 2));
        Post post3 = TestUtils.createRandomPost(userId);
        post3.setDate(LocalDate.of(2024, 1, 3));

        List<Post> mockedPosts = List.of(post2, post3, post1);

        when(userRepository.findById(userId)).thenReturn(Optional.of(TestUtils.createRandomUser()));

        when(followRepository.findFollowed(userId)).thenReturn(List.of(
                new Follow(userId, 2L)
        ));

        when(postRepository.findByIdSince(anyLong(), any(LocalDate.class))).thenReturn(mockedPosts);

        SellersPostsByFollowerResponseDto response = postService.searchFollowedPostsFromLastTwoWeeks(userId, "date_desc");


        List<LocalDate> dates = response.getPosts().stream().map(PostResponseDto::getDate).toList();

        assertEquals(List.of(
                LocalDate.of(2024, 1, 3),
                LocalDate.of(2024, 1, 2),
                LocalDate.of(2024, 1, 1)
        ), dates);
    }



}
