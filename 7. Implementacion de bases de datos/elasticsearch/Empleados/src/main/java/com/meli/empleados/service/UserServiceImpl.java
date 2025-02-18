package com.meli.empleados.service;

import com.meli.empleados.Dto.UserDto;
import com.meli.empleados.model.User;
import com.meli.empleados.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto user) {

        return toDto(userRepository.save(fromDto(user)));
    }

    @Override
    public List<UserDto> searchAll() {
        Iterable<User> usersIterable = userRepository.findAll();
        List<User> users = new ArrayList<>();
        usersIterable.forEach(users::add);
        return users.stream().map(u -> toDto(u)).toList();
    }

    private User fromDto(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setNombre(userDto.getNombre());
        return user;
    }

    private UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNombre(user.getNombre());
        return userDto;
    }
}
