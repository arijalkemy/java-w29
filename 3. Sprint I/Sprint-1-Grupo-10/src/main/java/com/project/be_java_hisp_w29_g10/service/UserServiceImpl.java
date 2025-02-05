package com.project.be_java_hisp_w29_g10.service;

import com.project.be_java_hisp_w29_g10.dto.response.FollowedSellerDto;
import com.project.be_java_hisp_w29_g10.dto.response.ResponseMessageDto;
import com.project.be_java_hisp_w29_g10.dto.response.UserFollowedSellerDto;
import com.project.be_java_hisp_w29_g10.entity.Follow;
import com.project.be_java_hisp_w29_g10.entity.User;
import com.project.be_java_hisp_w29_g10.exception.ConflictException;
import com.project.be_java_hisp_w29_g10.exception.NotFoundException;
import com.project.be_java_hisp_w29_g10.repository.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements IUserService{
    private final IUserRepository userRepository;
    private final ISellerRepository sellerRepository;
    private final IFollowRepository followRepository;
    private final IFollowService followService;
    private final IFollowManagementService followManagementServicve;


    public UserServiceImpl(IUserRepository userRepository, ISellerRepository sellerRepository, IFollowRepository followRepository, IFollowService followService, IFollowManagementService followManagementService) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
        this.followRepository = followRepository;
        this.followService = followService;
        this.followManagementServicve = followManagementService;
    }

    @Override
    public ResponseMessageDto followSeller(Long userId, Long userIdToFollow) {
        if (userRepository.findById(userId).isEmpty()){throw new NotFoundException("No se encontró el usuario con el ID: "+userId);}
        if (sellerRepository.findById(userIdToFollow).isEmpty()){throw new NotFoundException("No se encontró el vendedor con el ID: "+userIdToFollow);}
        if (!followRepository.getFollowRelation(userId,userIdToFollow).isEmpty()){throw new ConflictException("El usuario con ID: "+userId+" seguir al vendedor con ID: "+userIdToFollow+", debido a que ya lo está siguiendo.");}

        Follow newFollow = followRepository.saveFollow(userId, userIdToFollow);
        return new ResponseMessageDto("El usuario "+newFollow.getUser_id()+" ahora sigue al vendedor "+newFollow.getSeller_id());
    }

    @Override
    public ResponseMessageDto unfollowSeller(Long userId, Long userIdToUnfollow) {
        Optional<Follow> followRelation = followRepository.getFollowRelation(userId, userIdToUnfollow);
        if (userRepository.findById(userId).isEmpty()){ throw new NotFoundException("No se encontró el usuario con el ID: "+userId);}
        if (sellerRepository.findById(userIdToUnfollow).isEmpty()){ throw new NotFoundException("No se encontró el vendedor con el ID: "+userIdToUnfollow);}
        if (followRelation.isEmpty()){ throw new NotFoundException("El usuario con ID: "+userId+" no puede dejar se seguir al vendedor con ID: "+userIdToUnfollow+", ya que no lo sigue.");}

        followRepository.removeFollow(followRelation.get());
        return new ResponseMessageDto("El usuario "+userId+" a dejado de seguir al vendedor "+userIdToUnfollow);
    }

    //Metodo para recuperar el nombre de un usuario(US3)
    @Override
    public String getUserName(Long userId) {
        return userRepository.findById(userId).get().getUser_name();
    }
    //Metodo para devolver el usuario y la lista de vendedores que sigue(US4)
    @Override
    public UserFollowedSellerDto getUserAndFollowedSellers(Long userId) {
        if(followService.getSellersFollowedByUser(userId).isEmpty()) {
            throw new NotFoundException("No se encontro el usuario con el ID: "+userId);
        }
        List<Long> sellersFollowed = followService.getSellersFollowedByUser(userId);
        Optional<User> user = userRepository.findById(userId);
        List<FollowedSellerDto> followedSellerDtos = sellersFollowed.stream()
                .map(sellerId -> new FollowedSellerDto(sellerId, followManagementServicve.getSellerName(sellerId)))
                .toList();
        return new UserFollowedSellerDto(user.get().getUser_id(), user.get().getUser_name(), followedSellerDtos);
    }

    @Override
    public UserFollowedSellerDto OrderByName(UserFollowedSellerDto userFollowedSeller, String order) {
        List<FollowedSellerDto> followed = new ArrayList<>(userFollowedSeller.getFollowed());
        if (order.equals("name_asc")) {
            followed.sort(Comparator.comparing(FollowedSellerDto::getUser_name));
        } else if (order.equals("name_desc")) {
            followed.sort(Comparator.comparing(FollowedSellerDto::getUser_name).reversed());
        }else {
            throw new NotFoundException("No se encontro el tipo de ordenamiento especificado");
        }

        userFollowedSeller.setFollowed(followed);
        return userFollowedSeller;
    }

}