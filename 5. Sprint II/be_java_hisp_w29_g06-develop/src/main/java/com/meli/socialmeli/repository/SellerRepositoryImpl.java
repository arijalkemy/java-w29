package com.meli.socialmeli.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class SellerRepositoryImpl implements ISellerRepository{
    
    private List<Seller> sellers;

    public SellerRepositoryImpl() {
        this.sellers = new ArrayList<>();
    }

    @Override
    public Optional<Seller> getById(Integer id) {
        return this.sellers.stream().filter(seller -> seller.getId().equals(id)).findFirst();
    }

    @Override
    public boolean addFollower(Seller seller, User user) {
        return seller.getFollowers().add(user);
    }

    @Override
    public boolean isFollower(Seller seller, User user){
        return seller.getFollowers().contains(user);
    }

    @Override
    public boolean removeFollower(Seller seller, User user) {
        return seller.getFollowers().remove(user);
    }

    @Override
    public int countSellers() {
        return this.sellers.size();
    }

    @Override
    public Optional<Seller> save(Seller seller) {
        Optional<Seller> sellerOptional = this.getById(seller.getId());
        if (sellerOptional.isPresent()) {
            return sellerOptional;
        }
        this.sellers.add(seller);
        return Optional.of(seller);
    }


}
