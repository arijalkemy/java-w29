package com.project.be_java_hisp_w29_g10.service;

import com.project.be_java_hisp_w29_g10.repository.ISellerRepository;
import com.project.be_java_hisp_w29_g10.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowManagementService implements IFollowManagementService {
    private final IUserRepository userRepository;
    private final ISellerRepository sellerRepository;

    public FollowManagementService(IUserRepository userRepository, ISellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public String getUserName(Long userId) {
        return userRepository.findById(userId).get().getUser_name();
    }

    @Override
    public String getSellerName(Long sellerId) {
        return sellerRepository.findById(sellerId).get().getUser_name();
    }
}
