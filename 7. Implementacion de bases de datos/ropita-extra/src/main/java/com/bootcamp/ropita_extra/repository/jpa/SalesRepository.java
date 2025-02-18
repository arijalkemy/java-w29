package com.bootcamp.ropita_extra.repository.jpa;

import com.bootcamp.ropita_extra.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sale, String> {}
