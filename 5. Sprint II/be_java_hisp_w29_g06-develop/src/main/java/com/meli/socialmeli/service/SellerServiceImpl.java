package com.meli.socialmeli.service;

import com.meli.socialmeli.constants.Messages;
import com.meli.socialmeli.constants.OrderType;
import com.meli.socialmeli.dto.CreateSellerDto;
import com.meli.socialmeli.dto.FollowersDto;
import com.meli.socialmeli.dto.SellerDto;
import com.meli.socialmeli.dto.UserDto;
import com.meli.socialmeli.dto.response.ResponseDto;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import com.meli.socialmeli.exception.NotFoundException;
import com.meli.socialmeli.exception.NotFoundOrderException;
import com.meli.socialmeli.repository.ISellerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements ISellerService{

    private ISellerRepository sellerRepository;

    public SellerServiceImpl(ISellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public FollowersDto getFollowersBySellerId(Integer sellerId, String order){
        Optional<Seller> seller = sellerRepository.getById(sellerId);
        OrderType orderType = OrderType.fromString(order);

        if (orderType == OrderType.NOT_FOUND) {
            throw new NotFoundOrderException(Messages.ORDER_NOT_FOUND);
        }

        if (seller.isEmpty()) {
            throw new NotFoundException(Messages.SELLER_NOT_FOUND.replace("%s", sellerId.toString()));
        }

        List<User> listUser = seller.get().getFollowers();

        if(listUser.isEmpty()){
            throw new NotFoundException(Messages.NO_FOLLOWERS_ASSOCIATED);
        }

        if (orderType == OrderType.DESCENDING) {
            listUser.sort(Comparator.comparing(User::getName).reversed());
        } else {
            listUser.sort(Comparator.comparing(User::getName));
        }

        List<UserDto> listUserDto = listUser.stream()
                .map(user -> {
                    UserDto userDto = new UserDto();
                    userDto.setUser_id(user.getId());
                    userDto.setUser_name(user.getName());
                    return userDto;
                })
                .collect(Collectors.toList());

        return new FollowersDto(seller.get().getId(),seller.get().getName(),listUserDto);
    }


    @Override
    public SellerDto countFollowers(Integer id) {
        Optional<Seller> optionalSeller = sellerRepository.getById(id);
        if (optionalSeller.isPresent()) {
            Seller seller = optionalSeller.get();
            Integer followersCount = seller.getFollowers().size();
            return new SellerDto(seller.getId(), seller.getName(), followersCount);
        }
        throw new NotFoundException(Messages.SELLER_NOT_FOUND.replace("%s", id.toString()));
    }

    @Override
    public CreateSellerDto addSeller(CreateSellerDto createSellerDto) {
        int sellerId = sellerRepository.countSellers() + 1;
        Seller seller = new Seller(sellerId, createSellerDto.getUser_name(), new ArrayList<>());
        sellerRepository.save(seller);
        return new CreateSellerDto(seller.getId(), seller.getName());
    }


}
