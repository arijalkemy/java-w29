package com.meli.empleados.service;

import com.meli.empleados.Dto.UserDto;

import java.util.List;

public interface IUserService {
    UserDto save(UserDto user);
    List<UserDto> searchAll();
}
