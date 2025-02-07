package com.thiagoschreck.local.melisocial.service;

import com.thiagoschreck.local.melisocial.entity.user.Seller;

import com.thiagoschreck.local.melisocial.dto.request.CreateUserRequestDTO;
import com.thiagoschreck.local.melisocial.dto.response.CreateUserResponseDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.ClientDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerFollowersCountDTO;

public interface IUsersService {
    ClientDTO unfollowSeller(Integer userId, Integer userIdToUnfollow);

    SellerDTO getSellerFollowersByUserId(int userId, String order);

    CreateUserResponseDTO createClient(CreateUserRequestDTO request);

    CreateUserResponseDTO createSeller(CreateUserRequestDTO request);

    ClientDTO getClientFollowedSellersByUserId(int userId, String order);

    ClientDTO followSeller(Integer userId, Integer userIdToUnfollow);

    SellerFollowersCountDTO getSellerFollowersCount(int userId);
}
