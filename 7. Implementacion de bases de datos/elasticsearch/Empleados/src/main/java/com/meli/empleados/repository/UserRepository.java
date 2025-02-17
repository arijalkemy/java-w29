package com.meli.empleados.repository;

import com.meli.empleados.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, String> {

}
