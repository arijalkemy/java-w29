package com.bootcamp.be_java_hisp_w29_g07.controller;

import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListFollowedDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListFollowersDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.MessageDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.SellerFollowerCountDTO;
import com.bootcamp.be_java_hisp_w29_g07.service.IFollowService;
import com.bootcamp.be_java_hisp_w29_g07.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class defines a set of endpoints for managing users.
 */
@RestController
@RequestMapping("/users")
@Tag(name="User")
public class UserController {

    /**
     * The Follow service.
     */
    private final IFollowService followService;

    /**
     * Constructor that instantiates a new Post controller.
     *
     * @param followService the follow service
     */
    public UserController( IFollowService followService) {
        this.followService = followService;
    }

    /**
     * Retrieves the count of followers for a specific user.
     *
     * @param userId the ID of the user
     * @return a {@link ResponseEntity} containing the follower count
     */
    @Operation(summary = "Count the number of followers a user has")
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowerCountDTO> getSellerFollowerCount(@PathVariable Integer userId) {
        return new ResponseEntity<>(this.followService.getSellerFollowerCount(userId), HttpStatus.OK);
    }


    /**
     * Allows a user to follow another user.
     *
     * @param userId         the ID of the user initiating the follow
     * @param userIdToFollow the ID of the user to be followed
     * @return a {@link ResponseEntity} confirming the follow action
     */
    @Operation(summary = "Add a new follow by user")
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDTO> addFollow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return new ResponseEntity<>(followService.saveFollow(userId, userIdToFollow), HttpStatus.OK);
    }

    /**
     * Retrieves a list of followers for a specific user, with optional sorting.
     *
     * @param userId the ID of the user
     * @param order  the order for sorting (optional)
     * @return a {@link ResponseEntity} containing the list of followers
     */
    @Operation(summary = "List of a user's followers by ID")
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<ListFollowersDTO> findListFollowersByUserId(
            @PathVariable Integer userId,
            @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity<>(followService.findListFollowersByUserId(userId, order), HttpStatus.OK);
    }

    /**
     * Retrieves a list of users followed by a specific user, with optional sorting.
     *
     * @param userId the ID of the user
     * @param order  the order for sorting (optional)
     * @return a {@link ResponseEntity} containing the list of followed users
     */
    @Operation(summary = "List of users followed by a user")
    @GetMapping("{userId}/followed/list")
    public ResponseEntity<ListFollowedDTO> findListFollowedByUserId(
            @PathVariable Integer userId,
            @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity<>(followService.findListFollowedByUserId(userId, order), HttpStatus.OK);
    }

    /**
     * Allows a user to unfollow another user.
     *
     * @param userId           the ID of the user initiating the unfollow
     * @param userIdToUnfollow the ID of the user to be unfollowed
     * @return a {@link ResponseEntity} confirming the unfollow action
     */
    @Operation(summary = "Unfollow a user")
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDTO> unfollowUserById(
            @PathVariable Integer userId,
            @PathVariable Integer userIdToUnfollow) {
        return new ResponseEntity<>(followService.unfollowUserById(userId, userIdToUnfollow), HttpStatus.OK);
    }
}
