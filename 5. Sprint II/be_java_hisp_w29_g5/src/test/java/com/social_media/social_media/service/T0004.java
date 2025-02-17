package com.social_media.social_media.service;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.response.FollowedResponseDto;
import com.social_media.social_media.dto.response.UserResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.repository.follow.FollowRepositoryImpl;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.repository.user.UserRepositoryImpl;
import com.social_media.social_media.service.user.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T0004 {
    @Mock
    private UserRepositoryImpl userRepository;

    @Mock
    private FollowRepositoryImpl followRepository;

    @Mock
    private PostRepositoryImpl postRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Hola")
    void searchFollowed(){
        //Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
        User userFollower = TestUtils.createRandomUser();
        List <User> userFolloweds= TestUtils.createTenRandomUsers();
        List<Follow> followeds = new ArrayList<>();
        for(User userFollowed : userFolloweds){
            Follow follow = TestUtils.createFollow(userFollower.getUserId(),userFollowed.getUserId());
            followeds.add(follow);
        }

        //arrange
        when(userRepository.findById(userFollower.getUserId())).thenReturn(Optional.of(userFollower));
        when(followRepository.findFollowed(userFollower.getUserId())).thenReturn(followeds);
        for (Follow follow : followeds) {
            Optional<User> followedUser = userFolloweds.stream()
                    .filter(user -> user.getUserId().equals(follow.getFollowedId()))
                    .findFirst();

            when(userRepository.findById(follow.getFollowedId())).thenReturn(followedUser);
        }
        //act
        FollowedResponseDto response = userService.searchFollowed(userFollower.getUserId(), "name_asc");
        FollowedResponseDto expectedResponse = TestUtils.convertFollowedToResponseDto(userFollower, userFolloweds);

        //assert

        assertEquals(response.getUser_name(),expectedResponse.getUser_name());
        assertEquals(response.getUser_id(),expectedResponse.getUser_id());
        assertEquals(response.getFollowed().size(),expectedResponse.getFollowed().size());

    }
}
