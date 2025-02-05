package com.project.be_java_hisp_w29_g10.service;

import com.project.be_java_hisp_w29_g10.dto.response.ResponseMessageDto;
import com.project.be_java_hisp_w29_g10.dto.response.UserFollowedSellerDto;

public interface IUserService {
    ResponseMessageDto followSeller(Long userId, Long userIdToFollow);
    ResponseMessageDto unfollowSeller(Long userId, Long userIdToUnfollow);
    //Metodo para recuperar el nombre de un usuario(US3)
    String getUserName(Long userId);
    //Metodo para devolver el usuario y la lista de vendedores que sigue(US4)
    UserFollowedSellerDto getUserAndFollowedSellers(Long userId);
    //Metodo para ordenar por nombre los follower/followed
    UserFollowedSellerDto OrderByName(UserFollowedSellerDto userFolloewdSeller, String order);
}
