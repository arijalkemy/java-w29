package ejercicios_extra_p1.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejercicios_extra_p1.dtos.DressDto;
import ejercicios_extra_p1.services.IClothesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClothesController {

  private final IClothesService clothes_service;

  @PostMapping("/clothes")
  public ResponseEntity<Void> postApiClothes (
    @RequestBody DressDto dress_request_dto
  ) throws URISyntaxException {
    Long id = clothes_service.addDress(dress_request_dto);
    return ResponseEntity.created(new URI("/api/clothes/" + id)).build();
  }

  @GetMapping("/clothes")
  public ResponseEntity<List<DressDto>> getApiClothes(
    @RequestParam(required = false) String name
  ) {
    return ResponseEntity.ok(clothes_service.getAllDresses(name));
  }

  @GetMapping("/clothes/{code}")
  public ResponseEntity<List<DressDto>> getApiClothesCode(
    @PathVariable String code
  ) {
    return ResponseEntity.ok(clothes_service.getDressByCode(code));
  }

  @PutMapping("/clothes/{code}")
  public ResponseEntity<Void> putApiClothesCode(
    @PathVariable String code,
    @RequestBody DressDto dress_request_dto
  ) {
    clothes_service.updateDress(code, dress_request_dto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/clothes/{code}")
  public ResponseEntity<?> deleteApiClothesCode(
    @PathVariable String code
  ) {
    clothes_service.deleteDress(code);
    return ResponseEntity.ok().build();
  }
  
}