package com.meli.empleados.controller;

import com.meli.empleados.Dto.UserDto;
import com.meli.empleados.model.User;
import com.meli.empleados.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(this.userService.searchAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.CREATED);
    }
}
