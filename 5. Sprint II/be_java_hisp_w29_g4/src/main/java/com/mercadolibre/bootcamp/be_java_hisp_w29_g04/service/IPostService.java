package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.service;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.MessageDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PromoPostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.PostsBySellersFollowedDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.PromosByUserCountDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.PostOrderTypeEnum;

import java.util.List;

public interface IPostService{
    List<PostDto> getUserPosts(Integer userId);
    PostsBySellersFollowedDto getPostsOfFollowedSeller(Integer userId, PostOrderTypeEnum order);
    MessageDto createPromoPost(PromoPostDto post);
    MessageDto createPost(PostDto post);
    PromosByUserCountDto getPromoCount(Integer userId);
    List<PromoPostDto> getPromoPostsBySellerId(Integer seller_id);

    // CRUD
    List<PostDto> findAll();
    PostDto findById(Integer postId);
    PostDto save(PostDto e);
    MessageDto delete(Integer id);
    PostDto update(PostDto e);

    PostOrderTypeEnum getPostOrderType(String order);
}
