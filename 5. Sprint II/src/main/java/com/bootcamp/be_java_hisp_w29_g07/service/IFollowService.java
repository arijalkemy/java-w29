package com.bootcamp.be_java_hisp_w29_g07.service;

import com.bootcamp.be_java_hisp_w29_g07.dto.response.*;

import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListFollowersDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.MessageDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.SellerFollowerCountDTO;

import java.util.List;

/**
 * This interface provides methods to follow or unfollow users, retrieve the list of followers
 * or followings, and count the number of followers for a specific user.
 */
public interface IFollowService {

    SellerFollowerCountDTO getSellerFollowerCount(Integer userId);
    MessageDTO unfollowUserById(Integer userId, Integer userIdToUnfollow);
    MessageDTO saveFollow(Integer userId, Integer userIdToFollow);
    ListFollowedDTO findListFollowedByUserId(Integer userId, String order);
    ListFollowersDTO findListFollowersByUserId(Integer userId, String order);
    List<Integer> findFollowedByUserId(Integer userId);
}
