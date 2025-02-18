package com.bootcamp.jpa.repository;

import com.bootcamp.jpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<Users, Long> {
}
