package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.response.*;
import com.socialmeli.socialmeli.enums.Message;
import com.socialmeli.socialmeli.enums.Order;

import com.socialmeli.socialmeli.exception.*;
import com.socialmeli.socialmeli.models.Follow;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.repositories.IFollowRepository;
import com.socialmeli.socialmeli.repositories.IUserRepository;
import com.socialmeli.socialmeli.utils.MyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IFollowRepository followRepository;

    private final IUserRepository userRepository;

    // US 0001
    @Override
    public MessageDto follow(Integer followerId, Integer followedId) {
        User follower = getUserIfExists(followerId);
        User followed = getUserIfExists(followedId);

        throwIfNotSeller(followed);
        
        if (follower.equals(followed)) {
            throw new IllegalActionException(Message.CANNOT_FOLLOW_SELF.getStr());
        }

        Follow follow = new Follow(follower, followed);

        if (followRepository.exists(follow)) {
            throw new AlreadyExistsException(
                    Message.USER_ALREADY_FOLLOWED.format(followed.getName(), follower.getName())
            );
        }

        followRepository.add(follow);
        return new MessageDto(Message.USER_FOLLOWED.format(followed.getName()));
    }

    // US 0007
    @Override
    public MessageDto unfollow(Integer followerId, Integer followedId) {
        User follower = getUserIfExists(followerId);
        User followed = getUserIfExists(followedId);

        if (follower.equals(followed)) {
            throw new IllegalActionException(Message.CANNOT_UNFOLLOW_SELF.getStr());
        }

        Follow follow = new Follow(follower, followed);

        if (!followRepository.exists(follow)){
            throw new AlreadyExistsException(
                        Message.USER_NOT_FOLLOWED.format(followed.getName(), follower.getName())
            );
        }

        followRepository.delete(follow);
        return new MessageDto(Message.USER_UNFOLLOWED.format(followed.getName()));
    }

    // US 0002
    @Override
    public UserFollowerCountDto countFollowers(Integer id) {
        User user = getUserIfExists(id);
        List<Follow> follows = getAllFollowers(user);

        return new UserFollowerCountDto(user.getId(), user.getName(), follows.size());
    }

    // US 0003
    @Override
    public FollowerListDto getFollowerList(Integer userId, String order) {
        throwIfOrderInvalid(order);

        User user = getUserIfExists(userId);
        List<Follow> follows = getAllFollowers(user);

        List<UserDto> userListDto = follows.stream()
                .map(Follow::getUserFollower)
                .map(MyMapper::toUserDto)
                .toList();

        userListDto = orderListByName(order, userListDto);

        return new FollowerListDto(user.getId(), user.getName(), userListDto);
    }

    // US 0004
    @Override
    public FollowedListDto getFollowedList(Integer userId, String order) {
        throwIfOrderInvalid(order);
        User user = getUserIfExists(userId);

        List<UserDto> followed = followRepository
                .findAllByIdFollower(userId)
                .stream()
                .map(Follow::getUserFollowed)
                .map(MyMapper::toUserDto)
                .toList();

        followed = orderListByName(order, followed);

        return new FollowedListDto(user.getId(), user.getName(), followed);
    }

    // US 00016
    @Override
    public TopSellersDto getTopSellers() {
        List<UserFollowerCountDto> topSellers = followRepository.getTopSellers();

        if (topSellers.isEmpty()){
            throw new NotFoundException(Message.NO_SELLERS.getStr());
        }

        return new TopSellersDto(topSellers);
    }

    private List<UserDto> orderListByName(String order, List<UserDto> followed) {
        if (order.equals(String.format("name_%s", Order.ASC.getString())) || order.equals(String.format("name_%s", Order.DESC.getString()))) {
            followed = followed.stream()
                    .sorted(Comparator.comparing(UserDto::getName, order.endsWith(Order.ASC.getString())
                            ? Comparator.naturalOrder()
                            : Comparator.reverseOrder()))
                    .toList();
        }
        return followed;
    }

    private User getUserIfExists(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.USER_NOT_FOUND.format(id)));
    }

    private List<Follow> getAllFollowers(User user) {
        throwIfNotSeller(user);
        return followRepository.findAllByIdFollowed(user.getId());
    }

    private void throwIfOrderInvalid(String order) {
        if (!Objects.equals(order, String.format("name_%s", Order.ASC.getString())) &&
                !Objects.equals(order, String.format("name_%s", Order.DESC.getString()))) {
            throw new BadRequestException(Message.INVALID_ORDER.getStr());
        }
    }
    
    private void throwIfNotSeller(User user) {
         if (!user.getIsSeller()){
            throw new UserNotSellerException(Message.USER_NOT_SELLER.format(user.getName()));
        }
    }
}
