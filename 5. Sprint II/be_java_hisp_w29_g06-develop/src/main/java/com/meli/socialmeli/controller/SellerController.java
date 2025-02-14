package com.meli.socialmeli.controller;

import com.meli.socialmeli.constants.Endpoints;
import com.meli.socialmeli.dto.CreateSellerDto;
import com.meli.socialmeli.dto.SellerDto;
import com.meli.socialmeli.service.ISellerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerController {

    private ISellerService sellerService;

    public SellerController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping(Endpoints.BASE_SELLER)
    public ResponseEntity<CreateSellerDto> postSeller(@Valid @RequestBody CreateSellerDto createSellerDto) {
        return new ResponseEntity<>(sellerService.addSeller(createSellerDto), HttpStatus.CREATED);
    }

    @GetMapping(Endpoints.USERS_FOLLOWERS_COUNT)
    public ResponseEntity<SellerDto> countFollowers(@PathVariable Integer userId) {
        return new ResponseEntity<>(sellerService.countFollowers(userId), HttpStatus.OK);
    }
}
