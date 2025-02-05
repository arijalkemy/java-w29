package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.entity.Follow;

import java.util.List;
import java.util.Optional;

public interface IFollowRepository {
    Follow saveFollow(Long userId, Long userIdToFollow);
    Follow removeFollow(Follow followRelation);
    Optional<Follow> getFollowRelation(Long userId, Long userIdToFollow);
    //Metodo para devolver una lista con el id de los seguidores de un vendedor(US2 y US3)
    List<Long> getFollowersOfSeller(Long sellerId);
    //Metodo para devolver una lista con el id de los vendedores que sigue un usuario(US4)
    public List<Long> getSellersFollowedByUser(Long userId);
}
