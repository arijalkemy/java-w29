package com.bootcamp.shopcart.controller;

import com.bootcamp.shopcart.dto.CartRequestBody;
import com.bootcamp.shopcart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<?> postCart(@RequestBody CartRequestBody request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cartService.saveCart(request));
    }

}
