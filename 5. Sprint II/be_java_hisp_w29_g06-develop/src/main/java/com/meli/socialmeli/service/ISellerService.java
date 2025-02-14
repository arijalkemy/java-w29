package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.CreateSellerDto;
import com.meli.socialmeli.dto.FollowersDto;
import com.meli.socialmeli.dto.SellerDto;
import com.meli.socialmeli.dto.response.ResponseDto;

public interface ISellerService {
    FollowersDto getFollowersBySellerId(Integer sellerId, String order);
    SellerDto countFollowers(Integer id);
    CreateSellerDto addSeller(CreateSellerDto createSellerDto);
}
