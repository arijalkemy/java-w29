package com.mercadolibre.final_project_bootcamp_esp_2.repository;

import com.mercadolibre.final_project_bootcamp_esp_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}
