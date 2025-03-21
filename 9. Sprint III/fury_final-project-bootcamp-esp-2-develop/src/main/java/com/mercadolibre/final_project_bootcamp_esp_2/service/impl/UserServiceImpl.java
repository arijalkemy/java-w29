package com.mercadolibre.final_project_bootcamp_esp_2.service.impl;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.UserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.model.User;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.UserRole;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.UserRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerOne(UserDto newUser) {
        validatePassword(newUser);
        User user = new User();
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());
        user.setRole(UserRole.BUYER);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void validatePassword(UserDto dto) {
        if(!dto.getPassword().equals(dto.getRepeated_password())){
            throw new RuntimeException("Passwords don't match");
        }
    }

}