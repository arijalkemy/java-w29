package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import com.socialmeli.socialmeli.dto.response.MessageDto;
import com.socialmeli.socialmeli.dto.response.ProductListDto;
import com.socialmeli.socialmeli.dto.response.ProductSaleCountDto;

public interface IPostService {
    MessageDto savePostSale(PostSaleDto postDto);

    MessageDto savePost(PostDto postDto);

    ProductListDto getRecentPostFromUsers(String order, Integer userId);

    ProductSaleCountDto getProductSaleCountByUser(Integer userId);
}
