package com.social_media.social_media.controller;

import com.social_media.social_media.dto.response.FollowedResponseDto;
import com.social_media.social_media.dto.response.FollowersCountResponseDto;
import com.social_media.social_media.dto.response.FollowersResponseDto;
import com.social_media.social_media.dto.response.FollowingResponseDto;
import com.social_media.social_media.dto.response.FollowSuggestionResponseDto;
import com.social_media.social_media.dto.response.UserFavoritesResponseDto;
import com.social_media.social_media.dto.response.UserWithFavoritesPostResponseDto;
import com.social_media.social_media.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<FollowersCountResponseDto> getFollowersCount(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.searchFollowersCount(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> postUnfollowSeller(@PathVariable Long userId, @PathVariable Long userIdToUnfollow) {
        userService.unfollowSeller(userId, userIdToUnfollow);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowingResponseDto> postFollowSeller(@PathVariable Long userId,
                                                                 @PathVariable Long userIdToFollow) {
        return new ResponseEntity<>(userService.followSeller(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/follower/list")
    public ResponseEntity<FollowersResponseDto> getFollowers(@PathVariable Long userId,
                                                             @RequestParam(required = false, defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userService.searchFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedResponseDto> getFollowed(@PathVariable Long userId,
                                                           @RequestParam(required = false, defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userService.searchFollowed(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/suggestions")
    public ResponseEntity<List<FollowSuggestionResponseDto>> getFollowSuggestions(@PathVariable Long userId,
            @RequestParam(defaultValue = "3") Integer limit) {
        return new ResponseEntity<>(userService.searchFollowSuggestions(userId, limit), HttpStatus.OK);
    }

    @GetMapping("/{userId}/favorites/list")
    public ResponseEntity<UserFavoritesResponseDto> getFavorites(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.searchUserFavoritesPost(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/favorites/{postId}")
    public ResponseEntity<UserWithFavoritesPostResponseDto> postUpdateFavorites(@PathVariable Long userId,
                                                                                @PathVariable Long postId) {
        return new ResponseEntity<>(userService.updateUserFavoritesPost(userId, postId), HttpStatus.OK);
    }

}
