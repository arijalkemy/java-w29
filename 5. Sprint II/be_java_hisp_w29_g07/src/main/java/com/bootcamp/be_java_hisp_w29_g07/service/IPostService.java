package com.bootcamp.be_java_hisp_w29_g07.service;

import com.bootcamp.be_java_hisp_w29_g07.dto.PostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.request.PromoPostDTOIn;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListPostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PostSaveDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PromoCountPostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PromoPostDTOOut;

import java.util.List;

/**
 * This interface provides methods to create, retrieve, and manage posts, including retrieving posts
 * from users that are followed, counting promotional posts, and handling post creation
 * and promotion.
 */
public interface IPostService {

    ListPostDTO findListUsersFollowedPostsByUserId(Integer userId, String order);
    PromoCountPostDTO findPromoPostCountByUserId(Integer userId);
    PostSaveDTO addPost(PostDTO post);
    PostDTO findPostById(Integer id);
    List<PostDTO> findAll();
    PromoPostDTOOut createPromoPost(PromoPostDTOIn promoPostDTOIn);
    ListPostDTO findAllPostBySellerId(Integer sellerId);
}
