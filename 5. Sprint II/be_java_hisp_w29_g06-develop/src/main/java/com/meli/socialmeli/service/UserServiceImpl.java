package com.meli.socialmeli.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.meli.socialmeli.exception.NotFoundOrderException;
import org.springframework.stereotype.Service;

import com.meli.socialmeli.constants.Messages;
import com.meli.socialmeli.dto.FollowedDto;
import com.meli.socialmeli.dto.FollowedListResponseDto;
import com.meli.socialmeli.dto.UserDto;
import com.meli.socialmeli.dto.response.ResponseDto;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import com.meli.socialmeli.exception.BadRequestException;
import com.meli.socialmeli.exception.ConflictException;
import com.meli.socialmeli.exception.NotFoundException;
import com.meli.socialmeli.repository.ISellerRepository;
import com.meli.socialmeli.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;
    private ISellerRepository sellerRepository;

    public UserServiceImpl(IUserRepository userRepository, ISellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public ResponseDto followSeller(Integer userId, Integer sellerId) {

        Optional<User> user = userRepository.getById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException(Messages.USER_NOT_FOUND.replace("%s", userId.toString()));
        }
        Optional<Seller> seller = sellerRepository.getById(sellerId);
        if (seller.isEmpty()) {
            throw new NotFoundException(Messages.SELLER_NOT_FOUND.replace("%s", sellerId.toString()));
        }
        if (userRepository.isFollower(user.get(), seller.get())) {
            throw new ConflictException(Messages.USER_ALREADY_FOLLOWED);
        }
        userRepository.followSeller(user.get(), seller.get());
        sellerRepository.addFollower(seller.get(), user.get());

        return ResponseDto.builder().message(Messages.SUCCESS_FOLLOW).build();
    }

    @Override
    public ResponseDto unfollowSeller(Integer userId, Integer sellerId) {
        Optional<User> user = userRepository.getById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException(Messages.USER_NOT_FOUND.replace("%s", userId.toString()));
        }
        Optional<Seller> seller = sellerRepository.getById(sellerId);
        if (seller.isEmpty()) {
            throw new NotFoundException(Messages.SELLER_NOT_FOUND.replace("%s", sellerId.toString()));
        }
        if (this.sellerRepository.isFollower(seller.get(), user.get())) {
            this.userRepository.unfollowSeller(user.get(), seller.get());
            this.sellerRepository.removeFollower(seller.get(), user.get());
        } else {
            throw new NotFoundException(Messages.USER_NOT_FOLLOWING_SELLER);
        }

        return new ResponseDto(Messages.SUCCESS_UNFOLLOW);
    }

    @Override
    public FollowedListResponseDto getFollowedList(Integer userId, String order) {
        Optional<User> user = userRepository.getById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException(Messages.USER_NOT_FOUND.replace("%s", userId.toString()));
        }

        List<Seller> sellers = user.get().getFollows();

        if (sellers.isEmpty()) {
            throw new NotFoundException(Messages.USER_WITHOUT_FOLLOWED);
        }

        if ("name_desc".equals(order)) {
            sellers.sort(Comparator.comparing(Seller::getName).reversed());
        } else if ("name_asc".equals(order)) {
            sellers.sort(Comparator.comparing(Seller::getName));
        } else {
            throw new NotFoundOrderException(Messages.ORDER_NOT_FOUND);
        }

        List<FollowedDto> followedDtos = sellers.stream().map(seller -> new FollowedDto(seller.getId(),seller.getName())).toList();
        return new FollowedListResponseDto(user.get().getId(), user.get().getName(), followedDtos);
    }

    @Override
    public UserDto add(UserDto userDto) {
        Optional<User> userCreated = this.userRepository.save(
                User.builder().name(userDto.getUser_name()).follows(new ArrayList<>()).build()
        );

        if (userCreated.isEmpty()) {
            throw new BadRequestException(Messages.INTERNAL_ERROR);
        }

        return new UserDto(userCreated.get().getId(), userCreated.get().getName());
    }
}
