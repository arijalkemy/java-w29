package com.bootcamp.be_java_hisp_w29_g07.service;

import com.bootcamp.be_java_hisp_w29_g07.Enum.OrderType;
import com.bootcamp.be_java_hisp_w29_g07.Enum.UserType;
import com.bootcamp.be_java_hisp_w29_g07.constants.Messages;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListFollowersDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.MessageDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.SellerFollowerCountDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.*;
import com.bootcamp.be_java_hisp_w29_g07.entity.Follow;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w29_g07.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w29_g07.repository.IFollowRepository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This class provides the business logic for managing follow relationships between users.
 * It includes operations for following, unfollowing, retrieving followers and followed users,
 * and validating business rules such as user types and permissions.
 */
@Service
public class FollowServiceImpl implements IFollowService {

    /**
     * The Follow repository for managing follow-related operations.
     */
    private final IFollowRepository followRepository;

    /**
     * The User service for retrieving and validating user information.
     */
    private final IUserService userService;

    /**
     * Instantiates a new Follow service.
     *
     * @param followRepository the follow repository
     * @param userService      the user service
     */
    public FollowServiceImpl(
            IFollowRepository followRepository,
            IUserService userService
    ) {
        this.followRepository = followRepository;
        this.userService = userService;
    }

    /**
     * Gets the count of followers for a specific seller and
     * validates that the user is a seller and retrieves the total number of followers.
     *
     * @param userId the user ID
     * @return a {@link SellerFollowerCountDTO} containing the seller ID, username, and follower count
     * @throws BadRequestException if the user is not a seller
     */
    @Override
    public SellerFollowerCountDTO getSellerFollowerCount(Integer userId) {
        User userFound = this.userService.findUserById(userId);
        if (!userFound.getUserType().equals(UserType.SELLER)) {
            throw new BadRequestException(Messages.USER_NOT_SELLER_MSG);
        }

        Long followerCount = this.followRepository.countByFollowedId(userId);
        return new SellerFollowerCountDTO(
                userFound.getId(),
                userFound.getUsername(),
                followerCount
        );
    }

    /**
     * Unfollows a user by their ID.
     * Validates the existence of both users and checks if the relationship exists before unfollowing.
     *
     * @param userId           the ID of the user performing the unfollow action
     * @param userIdToUnfollow the ID of the user to unfollow
     * @return a {@link MessageDTO} containing a success message
     * @throws NotFoundException if the relationship does not exist
     */
    @Override
    public MessageDTO unfollowUserById(Integer userId, Integer userIdToUnfollow) {

        userService.verifyUserExists(userId);
        userService.verifyUserExists(userIdToUnfollow);

        Integer numberOfFollowsDeleted = followRepository.deleteFollowUserById(userId, userIdToUnfollow);
        if (numberOfFollowsDeleted.equals(0)) {
            throw new NotFoundException(String.format(Messages.USER_IS_NOT_FOLLOWING_USER, userId, userIdToUnfollow));
        }

        return new MessageDTO(String.format(Messages.USER_HAS_UNFOLLOWED_USER, userId, userIdToUnfollow));
    }

    /**
     * Saves a follow relationship between two users.
     * Validates user types and ensures the relationship does not already exist.
     *
     * @param userId         the ID of the user performing the follow action
     * @param userIdToFollow the ID of the user to follow
     * @return a {@link MessageDTO} containing a success message
     * @throws BadRequestException if the relationship is invalid or already exists
     */
    @Override
    public MessageDTO saveFollow(Integer userId, Integer userIdToFollow) {
        User user = userService.findUserById(userId);
        User userToFollow = userService.findUserById(userIdToFollow);

        if(user.getId().equals(userToFollow.getId())){
            throw new BadRequestException(Messages.USER_NOT_FOLLOW_THEMSELVES_MSG);
        }
        if(user.getUserType().equals(UserType.SELLER)){
            throw new BadRequestException(Messages.SELLER_CANNOT_FOLLOW_SELLER);
        }
        if(userToFollow.getUserType().equals(UserType.USER)){
            throw new BadRequestException(Messages.USER_NOT_SELLER_MSG);
        }
        Optional<Follow> existFollow = followRepository.findFollow(user, userToFollow);
        if(existFollow.isPresent()){
            throw new BadRequestException(Messages.USER_ALREADY_FOLLOW_SELLER);
        }
        Follow follow = followRepository.saveFollow(user, userToFollow);
        return new MessageDTO(String.format(Messages.USER_FOLLOW_SELLER, follow.getFollower().getName(), follow.getFollowed().getName()));
    }

    /**
     * Retrieves a list of users followed by a specific user.
     * Applies optional sorting based on the order parameter.
     *
     * @param userId the ID of the user
     * @param order  the sorting order (e.g., ascending or descending by username)
     * @return a {@link ListFollowedDTO} containing the list of followed users
     */
    @Override
    public ListFollowedDTO findListFollowedByUserId(Integer userId, String order) {
        // Validates that the user exists
        User user = userService.findUserById(userId);
        List<UserDTO> followList = new ArrayList<>(followRepository.findFollowedByUserId(userId)
                .stream()
                .map(follow -> new UserDTO(follow.getFollowed().getId(), follow.getFollowed().getUsername()))
                .toList());

        orderList(followList, order, Comparator.comparing(UserDTO::getUserName));

        return new ListFollowedDTO(user.getId(), user.getUsername(), followList);
    }

    /**
     * Retrieves a list of followers for a specific user.
     * Applies optional sorting based on the order parameter.
     *
     * @param userId the ID of the user
     * @param order  the sorting order (e.g., ascending or descending by username)
     * @return a {@link ListFollowersDTO} containing the list of followers
     */
    @Override
    public ListFollowersDTO findListFollowersByUserId(Integer userId, String order) {
        // Validates that the user exists
        User user = userService.findUserById(userId);
        List<UserDTO> followList = new ArrayList<>(followRepository.findFollowersByUserId(userId)
                .stream()
                .map(follow -> new UserDTO(follow.getFollower().getId(), follow.getFollower().getUsername()))
                .toList());

        orderList(followList, order, Comparator.comparing(UserDTO::getUserName));

        return new ListFollowersDTO(user.getId(), user.getUsername(), followList);
    }

    @Override
    public List<Integer> findFollowedByUserId(Integer userId) {
        return followRepository.findFollowedByUserId(userId).stream()
                .map(f -> f.getFollowed().getId())
                .toList();
    }

    /**
     * Orders a list based on the provided comparator and order type.
     *
     * @param <T>        the type parameter for the list elements
     * @param list       the list to order
     * @param order      the sorting order (e.g., ascending or descending)
     * @param comparator the comparator to define the sorting logic
     * @return the ordered list
     */
    private <T> List<T> orderList(List<T> list, String order, Comparator<T> comparator) {
        if (Objects.isNull(order)) {
            return list;
        }
        if (order.equals(OrderType.ASC.getOrderType())) {
            list.sort(comparator);
        } else if (order.equals(OrderType.DESC.getOrderType())) {
            list.sort(comparator.reversed());
        } else {
            throw new BadRequestException(Messages.ORDER_DOES_NOT_EXIST);
        }
        return list;
    }
}
