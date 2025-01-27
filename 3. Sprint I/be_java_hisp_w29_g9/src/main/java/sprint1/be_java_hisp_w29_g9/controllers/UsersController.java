package sprint1.be_java_hisp_w29_g9.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sprint1.be_java_hisp_w29_g9.services.IUserService;

@RequiredArgsConstructor
@RestController
public class UsersController {
  private final IUserService userService;
  
  @PostMapping("/users/{userId}/follow/{userIdToFollow}")
  public ResponseEntity<?> postFollowUser(
    @PathVariable Integer userId,
    @PathVariable Integer userIdToFollow
  ){
    userService.followUser(userId, userIdToFollow);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/users/{userId}/followers/count")
  public ResponseEntity<?> getFollowersCount(
          @PathVariable Integer userId
  ){
    return ResponseEntity.ok(userService.numberOfFollowersForSeller(userId));
  }

  @GetMapping("/users/{userId}/followers/list")
  public ResponseEntity<?> getFollowersList(
    @PathVariable Integer userId,
    @RequestParam(required = false) String order
  ){
    return new ResponseEntity<>(userService.getFollowersList(userId,order), HttpStatus.OK);
  }

  @GetMapping("/users/{userId}/followed/list")
  public ResponseEntity<?> getFollowedList(
    @PathVariable Integer userId,
    @RequestParam(required = false) String order
  ){
    return new ResponseEntity<>(userService.userFollowed(userId,order), HttpStatus.OK);
  }

  @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
  public ResponseEntity<?> postUnfollowUser(
    @PathVariable Integer userId,
    @PathVariable Integer userIdToUnfollow
  ){
    userService.unfollowUser(userId,userIdToUnfollow);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
