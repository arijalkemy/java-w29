package com.app.service;

import com.app.dto.response.*;
import com.app.exception.BadRequestException;
import com.app.exception.EntityNotFoundException;
import com.app.exception.ForbiddenException;
import com.app.model.User;
import com.app.repository.IUserRepository;
import com.app.util.NameOrder;
import com.app.util.ResponseMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public FollowersCountDTO searchFollowersCount(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_FOUND.format(userId)));

        if (!user.getIsSeller()) {
            throw new BadRequestException(ResponseMessages.ERROR_SELLER_NOT_FOUND.format(userId));
        }

        Integer followersCount = userRepository.findFollowersCountById(userId);
        return new FollowersCountDTO(userId, user.getName(), followersCount);
    }

    @Override
    public SuccessDTO deleteFollowedSeller(int userId, int userIdToUnfollow) {

        if (userId == userIdToUnfollow) {
            throw new BadRequestException(ResponseMessages.ERROR_USER_ID_MATCH.format(userId));
        }

        userRepository
                .findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_FOUND.format(userId)));

        User seller = userRepository
                .findById(userIdToUnfollow)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_FOUND.format(userIdToUnfollow)));

        if (!seller.getIsSeller()) {
            throw new ForbiddenException(ResponseMessages.ERROR_USER_NOT_SELLER.format(userIdToUnfollow));
        }

        boolean isFollowing = seller
                .getFollowers()
                .stream()
                .anyMatch(followerId -> followerId == userId);

        if (!isFollowing) {
            throw new BadRequestException(ResponseMessages.ERROR_USER_UNFOLLOW_FAILED.format(userId, userIdToUnfollow));
        }

        userRepository.deleteFollowedSeller(userId, userIdToUnfollow);

        return new SuccessDTO(ResponseMessages.SUCCESS_USER_UNFOLLOWED.format(userIdToUnfollow));
    }


    @Override
    public SuccessDTO followUser(int userId, int userIdToFollow) {
        // check if it's the same user

        if (userId == userIdToFollow) {
            throw new BadRequestException(ResponseMessages.ERROR_USER_ID_MATCH.format(userId));
        }
        // check if user with userId exists
        User followerUser = userRepository
                .findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_FOUND.format(userId)));

        User followedUser = userRepository
                .findById(userIdToFollow)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_FOUND.format(userIdToFollow)));

        if (!followedUser.getIsSeller()) {
            throw new BadRequestException(ResponseMessages.ERROR_USER_NOT_SELLER.format(userIdToFollow));
        }

        // check if already following
        boolean isFollowing = followedUser
                .getFollowers()
                .stream()
                .anyMatch(followerId -> followerId == userId);

        if (isFollowing) {
            throw new BadRequestException(ResponseMessages.ERROR_USER_ALREADY_FOLLOWING.format(userId, userIdToFollow));
        }

        // update both lists

        followedUser.getFollowers().add(userId);
        followerUser.getFollowing().add(userIdToFollow);

        // since it's all on memory, it's not necessary to manually save with the repo
        // something similar to using transactional annotation
        return new SuccessDTO(ResponseMessages.SUCCESS_USER_FOLLOWED.format(userId, userIdToFollow));
    }

    @Override
    public FollowedListDTO searchFollowedList(int userId, String order) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_FOUND.format(userId)));

        List<User> followedSellers = userRepository.findFollowingUsersList(userId, getValidatedOrder(order));

        List<UserDTO> followedSellersDTO = followedSellers.stream()
                .map(this::convertToUserDTO)
                .toList();

        return new FollowedListDTO(user.getId(), user.getName(), followedSellersDTO);
    }

    @Override
    public FollowerListDTO searchFollowerList(int userId, String order) {
        User user = userRepository
                .findSellerById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_SELLER_NOT_FOUND.format(userId)));

        List<User> followersUsers = userRepository.findFollowersUsersList(userId, getValidatedOrder(order));

        List<UserDTO> followersUsersDTO = followersUsers.stream()
                .map(this::convertToUserDTO)
                .toList();

        return new FollowerListDTO(userId, user.getName(), followersUsersDTO);
    }

    @Override
    public List<UserDTO> searchAll() {
        List<User> users = this.userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getId(), user.getName()))
                .toList();
    }

    private UserDTO convertToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getName());
    }

    private String getValidatedOrder(String order) {
        if (order == null) return null;
        if (!NameOrder.NAME_ASC.getValue().equalsIgnoreCase(order) &&
                !NameOrder.NAME_DESC.getValue().equalsIgnoreCase(order)) {
            throw new BadRequestException(ResponseMessages.ERROR_INVALID_ORDER.format(""));
        }
        return order;
    }

}
