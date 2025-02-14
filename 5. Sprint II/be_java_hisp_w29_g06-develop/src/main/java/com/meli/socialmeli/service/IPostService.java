package com.meli.socialmeli.service;


import com.meli.socialmeli.dto.NumberOfProductsInSaleDto;
import com.meli.socialmeli.dto.PostDto;
import com.meli.socialmeli.dto.response.PostFromFollowedDto;
import com.meli.socialmeli.dto.response.ProductsOfSellerDto;
import com.meli.socialmeli.dto.response.ResponseDto;

import java.util.List;

public interface IPostService {
    NumberOfProductsInSaleDto getNumberOfProductsInSaleBySellerId(Integer userId);
    ProductsOfSellerDto getAllProductsInSaleBySellerId(Integer sellerId);
    ResponseDto addPost(PostDto post);
    ResponseDto addPromoPost(PostDto promoPostDto);
    PostFromFollowedDto getPostsFromFollowedUsers(Integer userId, Integer order);
    List<PostDto> filterPostsByPrice(Double minPrice, Double maxPrice);
}
