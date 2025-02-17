package com.app.service;

import com.app.dto.response.*;
import com.app.exception.*;
import com.app.model.User;
import com.app.repository.IUserRepository;
import com.app.util.MessageUtil;
import com.app.util.NameOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public FollowersCountDTO searchFollowersCount(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.user.not_found", userId)));

        if (!user.getIsSeller()) {
            throw new BadRequestException(MessageUtil.getMessage("error.user.not_seller", userId));
        }

        Integer followersCount = userRepository.findFollowersCountById(userId);
        return new FollowersCountDTO(userId, user.getName(), followersCount);
    }

    @Override
    public SuccessDTO deleteFollowedSeller(int userId, int userIdToUnfollow) {

        if (userId == userIdToUnfollow) {
            throw new BadRequestException(MessageUtil.getMessage("error.user.id.match", userId));
        }

        userRepository
                .findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.user.not_found", userId)));

        User seller = userRepository
                .findById(userIdToUnfollow)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.user.not_found", userIdToUnfollow)));

        if (!seller.getIsSeller()) {
            throw new ForbiddenException(MessageUtil.getMessage("error.user.not_seller", userIdToUnfollow));
        }

        Boolean state = userRepository.deleteFollowedSeller(userId, userIdToUnfollow);

        if (!state) {
            throw new EntityNotFoundException(MessageUtil.getMessage("error.user.unfollow_failed", userIdToUnfollow));
        }

        return new SuccessDTO(MessageUtil.getMessage("success.user.unfollowed", userIdToUnfollow));
    }


    @Override
    public SuccessDTO followUser(int userId, int userIdToFollow) {
        // check if it's the same user

        if (userId == userIdToFollow) {
            throw new BadRequestException(MessageUtil.getMessage("error.user.id.match", userId));
        }
        // check if user with userId exists
        User followerUser = userRepository
                .findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.user.not_found", userId)));

        User followedUser = userRepository
                .findById(userIdToFollow)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.user.not_found", userIdToFollow)));

        if (!followedUser.getIsSeller()) {
            throw new BadRequestException(MessageUtil.getMessage("error.user.not_seller", userIdToFollow));
        }

        // check if already following

        boolean isFollowing = followedUser
                .getFollowers()
                .stream()
                .anyMatch(followerId -> followerId == userId);

        if (isFollowing) {
            throw new BadRequestException(MessageUtil.getMessage("error.user.already_following", userId, userIdToFollow));
        }

        // update both lists

        followedUser.getFollowers().add(userId);
        followerUser.getFollowing().add(userIdToFollow);

        // since it's all on memory, it's not necessary to manually save with the repo
        // something similar to using transactional annotation

        return new SuccessDTO(MessageUtil.getMessage("success.user.followed", userId, userIdToFollow));

    }

    @Override
    public FollowedListDTO searchFollowedList(int userId, String order) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.user.not_found", userId)));

        List<User> followedSellers = userRepository.findFollowingUsersList(userId);
        checkForMissingUsers(followedSellers);

        List<UserDTO> followedSellersDTO = sortUsers(followedSellers, order);

        return new FollowedListDTO(user.getId(), user.getName(), followedSellersDTO);
    }

    @Override
    public FollowerListDTO searchFollowerList(int userId, String order) {
        User user = userRepository
                .findSellerById(userId)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.seller.not_found", userId)));

        List<User> followersUsers = userRepository.findFollowersUsersList(userId);
        checkForMissingUsers(followersUsers);

        List<UserDTO> followersUsersDTO = sortUsers(followersUsers, order);

        return new FollowerListDTO(userId, user.getName(), followersUsersDTO);
    }

    @Override
    public List<UserDTO> searchAll() {
        List<User> users = this.userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getName(), user.getId()))
                .toList();
    }

    private List<UserDTO> sortUsers(List<User> users, String order) {
        boolean isValidOrder = isValidOrderValue(order);
        List<User> sortedUsers = isValidOrder
                ? userRepository.sortUsersByName(users, NameOrder.fromValue(order))
                : users;

        return sortedUsers.stream()
                .map(this::convertToUserDTO)
                .toList();
    }

    private UserDTO convertToUserDTO(User user) {
        return new UserDTO(user.getName(), user.getId());
    }

    private void checkForMissingUsers(List<User> users) {
        users.forEach(u -> {
            if (u == null)
                throw new EntityNotFoundException(MessageUtil.getMessage("error.seller.not_found", u.getId()));
        });
    }

    private boolean isValidOrderValue(String order) {
        if (order == null) {
            return false;
        }
        if (!NameOrder.NAME_ASC.getValue().equalsIgnoreCase(order) &&
                !NameOrder.NAME_DESC.getValue().equalsIgnoreCase(order)) {
            throw new BadRequestException(MessageUtil.getMessage("error.invalid.order", ""));
        }
        return true;
    }

}
