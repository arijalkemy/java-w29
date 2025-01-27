package com.socialmeli.socialmeli.controllers;

import com.socialmeli.socialmeli.dto.response.CategoryCountByUserDto;
import com.socialmeli.socialmeli.dto.response.CategoryCountDto;
import com.socialmeli.socialmeli.dto.response.RankingPostSellerDto;
import com.socialmeli.socialmeli.dto.response.TopSellersDto;
import com.socialmeli.socialmeli.services.IPostService;
import com.socialmeli.socialmeli.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportsController {

    private final IPostService postService;
    private final IUserService userService;

    // US 00016 - Obtener un listado ordenado por los vendedores con más seguidores.
    @GetMapping("/top-sellers")
    public ResponseEntity<TopSellersDto> getTopSellers() {
        return ResponseEntity.ok(userService.getTopSellers());
    }

    // US 0017 - Obtener un listado ordenado por los vendedores con más posts.
    @GetMapping("/ranking-user-for-post")
    public ResponseEntity<List<RankingPostSellerDto>> getRankingSellerForPost(){
        return ResponseEntity.ok(postService.getRankingSellerForPost());
    }

    // US 0018 - Obtener un reporte de cantidad de posteos por categoría.
    @GetMapping("/categories/{idUser}")
    public ResponseEntity<CategoryCountByUserDto> getCategoryReportByUser(@PathVariable Integer idUser) {
        return ResponseEntity.ok(postService.getCategoryReportByUser(idUser));
    }

    // US 0019 - Obtener un reporte de cantidad de posteos por categoría de un vendedor determinado.
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryCountDto>> getCategoryReportForAll() {
        return ResponseEntity.ok(postService.getCategoryReportForAll());
    }
}
