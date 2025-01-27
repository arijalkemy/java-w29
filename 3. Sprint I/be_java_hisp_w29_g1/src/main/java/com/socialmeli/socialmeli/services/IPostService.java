package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import com.socialmeli.socialmeli.dto.request.CommentRequestDto;
import com.socialmeli.socialmeli.dto.response.MessageDto;
import com.socialmeli.socialmeli.dto.response.PostIdDto;
import com.socialmeli.socialmeli.dto.response.ProductListDto;
import com.socialmeli.socialmeli.dto.response.ProductSaleCountDto;
import com.socialmeli.socialmeli.dto.response.ProductsPromotionDto;
import com.socialmeli.socialmeli.dto.response.RankingPostSellerDto;
import com.socialmeli.socialmeli.dto.response.*;
import java.util.List;

public interface IPostService {
    MessageDto savePostSale(PostSaleDto postDto);

    MessageDto savePost(PostDto postDto);

    ProductListDto getRecentPostFromUsers(String order, Integer userId);

    ProductSaleCountDto getProductSaleCountByUser(Integer userId);

    List<PostIdDto> getFilteredPosts(String category, String priceRange, String productBrand, String productType);
    
    List<ProductsPromotionDto> getProductSaleCount(Integer userId);

    List<RankingPostSellerDto> getRankingSellerForPost();

    MessageDto addComment(Integer postId, CommentRequestDto commentDto);

    CategoryCountByUserDto getCategoryReportByUser(Integer idUser);

    List<CategoryCountDto> getCategoryReportForAll();

    CommentsListDto getCommentsById(Integer postId);
}
