package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.entity.Follow;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FollowRepositoryImpl implements  IFollowRepository {
   private List<Follow> follows;



    public FollowRepositoryImpl(){
        follows = new ArrayList<>(List.of(
                new Follow(1L,2L),
                new Follow(1L,1L),
                new Follow(1L,10L),
                new Follow(1L,9L),
                new Follow(1L,3L),
                new Follow(2L,1L),
                new Follow(2L,8L),
                new Follow(2L,5L),
                new Follow(2L,6L),
                new Follow(3L,10L),
                new Follow(3L,4L),
                new Follow(3L,9L),
                new Follow(3L,2L),
                new Follow(4L,8L),
                new Follow(4L,3L),
                new Follow(4L,5L),
                new Follow(4L,1L),
                new Follow(5L,2L),
                new Follow(5L,7L),
                new Follow(5L,10L),
                new Follow(5L,9L),
                new Follow(6L,1L),
                new Follow(6L,4L),
                new Follow(6L,8L),
                new Follow(7L,5L),
                new Follow(7L,2L),
                new Follow(7L,3L),
                new Follow(8L,1L),
                new Follow(8L,10L),
                new Follow(9L,6L),
                new Follow(9L,7L),
                new Follow(9L,8L),
                new Follow(10L,3L),
                new Follow(10L,1L),
                new Follow(10L,6L),
                new Follow(10L,2L)
        ));
    }

    @Override
    public Follow saveFollow(Long userId, Long userIdToFollow) {
        Follow newFollow = new Follow(userIdToFollow, userId);
        follows.add(newFollow);
        return newFollow;
    }

    @Override
    public Follow removeFollow(Follow followRelation) {
        follows.remove(followRelation);
        return followRelation;
    }

    @Override
    public Optional<Follow> getFollowRelation(Long userId, Long userIdToFollow) {
        return follows.stream().filter(follow -> follow.getSeller_id().equals(userIdToFollow) && follow.getUser_id().equals(userId)).findFirst();
    }

    //Metodo para devolver una lista con el id de los seguidores de un vendedor(US2 y US3)
    @Override
    public List<Long> getFollowersOfSeller(Long sellerId) {
        return follows.stream().filter(follow -> follow.getSeller_id().equals(sellerId)).map(Follow::getUser_id).toList();
    }

    //Metodo para devolver una lista con el id de los vendedores que sigue un usuario(US4)
    @Override
    public List<Long> getSellersFollowedByUser(Long userId) {
        return follows.stream().filter(follow -> follow.getUser_id().equals(userId)).map(Follow::getSeller_id).toList();
    }
}
