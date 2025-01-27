package com.app.service;

import com.app.dto.request.PostDTO;
import com.app.dto.request.ProductDTO;
import com.app.dto.response.PostListDTO;
import com.app.dto.response.PromoPostUserDTO;
import com.app.dto.response.PromoProductsCountDTO;
import com.app.dto.response.SuccessDTO;
import com.app.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface IPostService {
    PromoProductsCountDTO searchPromoProductsCountByUserId(Integer userId);

    PromoPostUserDTO searchListPromoProductsSinceDate(Integer userId, LocalDate since);

    PostDTO createPost(PostDTO postDTO);

    SuccessDTO addPromoPost(PostDTO postRequest);

    Product addProduct(ProductDTO productToAdd);

    PostListDTO searchPostsFromFollowedUsers(int userId, String dateOrder);

    List<PostDTO> searchAll();

    List<ProductDTO> searchAllProducts();
}
