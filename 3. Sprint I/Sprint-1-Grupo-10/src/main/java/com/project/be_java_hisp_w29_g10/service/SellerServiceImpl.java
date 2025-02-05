package com.project.be_java_hisp_w29_g10.service;

import com.project.be_java_hisp_w29_g10.dto.response.FollowerDto;
import com.project.be_java_hisp_w29_g10.dto.response.FollowersCountDto;
import com.project.be_java_hisp_w29_g10.dto.response.SellerFollowersDto;
import com.project.be_java_hisp_w29_g10.entity.Seller;
import com.project.be_java_hisp_w29_g10.exception.NotFoundException;
import com.project.be_java_hisp_w29_g10.repository.ISellerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements ISellerService{
    private final IFollowService followService;
    private final ISellerRepository sellerRepository;
    private final UserServiceImpl userServiceImpl;

    public SellerServiceImpl(IFollowService followService, ISellerRepository sellerRepository, UserServiceImpl userServiceImpl) {
        this.followService = followService;
        this.sellerRepository = sellerRepository;
        this.userServiceImpl = userServiceImpl;
    }

    //Metodo para devolver la cantidad de seguidores de un vendedor(US2)
    @Override
    public FollowersCountDto getCountFollowers(Long sellerId) {
        if(followService.getFollowersOfSeller(sellerId).isEmpty()) {
            throw new NotFoundException("No se encontro el vendedor con el ID: "+sellerId);
        }
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        return new FollowersCountDto (seller.get().getId_seller(),seller.get().getUser_name(),followService.getFollowersOfSeller(sellerId).size());
    }

    //Metodo para devolver al vendedor y su lista de seguidores(US3)
    @Override
    public SellerFollowersDto getSellerAndFollowers(Long sellerId) {
        if(followService.getFollowersOfSeller(sellerId).isEmpty()) {
            throw new NotFoundException("No se encontro el vendedor con el ID: "+sellerId);
        }
        List<Long> followers = followService.getFollowersOfSeller(sellerId);
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        List<FollowerDto> followerDtos = followers.stream()
                .map(followerId -> new FollowerDto(followerId, userServiceImpl.getUserName(followerId)))
                .toList();
        return new SellerFollowersDto(seller.get().getId_seller(), seller.get().getUser_name(), followerDtos);
    }
    @Override
    public Optional<Seller> getSellerById(Long userId) {
        return sellerRepository.findById(userId);
    }

    @Override
    public SellerFollowersDto OrderByName(SellerFollowersDto sellerFollowers, String order) {
        List<FollowerDto> followers = new ArrayList<>(sellerFollowers.getFollowers());
        if (order.equals("name_asc")) {
            followers.sort(Comparator.comparing(FollowerDto::getUser_name));
        } else if (order.equals("name_desc")) {
            followers.sort(Comparator.comparing(FollowerDto::getUser_name).reversed());
        }else {
            throw new NotFoundException("No se encontro el tipo de ordenamiento especificado");
        }
        sellerFollowers.setFollowers(followers);
        return sellerFollowers;
    }
}
