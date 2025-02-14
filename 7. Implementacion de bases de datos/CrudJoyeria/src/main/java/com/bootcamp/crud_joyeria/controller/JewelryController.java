package com.bootcamp.crud_joyeria.controller;

import com.bootcamp.crud_joyeria.dto.request.CreateJewelRequestBody;
import com.bootcamp.crud_joyeria.dto.response.ApiResponse;
import com.bootcamp.crud_joyeria.dto.response.JewelResponseBody;
import com.bootcamp.crud_joyeria.service.JewelryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jewelry")
@RequiredArgsConstructor
public class JewelryController {

    private final JewelryService jewelryService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createJewel(@RequestBody CreateJewelRequestBody request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(jewelryService.createJewel(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<JewelResponseBody>>> getAllJewelry() {
        return ResponseEntity.ok(new ApiResponse<>(jewelryService.getAllJewelry()));
    }

    @PutMapping("update/{jewelId}")
    public ResponseEntity<ApiResponse<JewelResponseBody>> updateJewel(@RequestBody CreateJewelRequestBody request, @PathVariable long jewelId) {
        return ResponseEntity.ok(new ApiResponse<>(jewelryService.updateJewel(jewelId, request)));
    }

    @DeleteMapping("delete/{jewelId}")
    public ResponseEntity<ApiResponse<String>> deleteJewel(@PathVariable long jewelId) {
        return ResponseEntity.ok(new ApiResponse<>(jewelryService.deleteJewel(jewelId)));
    }
}
