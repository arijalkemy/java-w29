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
import ejercicios_extra_p1.dtos.SaleDto;
import ejercicios_extra_p1.entities.Dress;
import ejercicios_extra_p1.services.ISalesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SalesController {
  private final ISalesService sales_service;

  @PostMapping("/sale")
  public ResponseEntity<?> postSale(
    @RequestBody SaleDto sale_dto
  ) throws URISyntaxException {
    Long id = sales_service.createSale(sale_dto);
    return ResponseEntity.created(new URI("/api/sale/" + id)).build();
  }

  @GetMapping("/sale")
  public ResponseEntity<?> getSales(
    @RequestParam(required = false) String date
  ){
    return ResponseEntity.ok().build();
  }

  @GetMapping("/sale/{number}")
  public ResponseEntity<?> getSale(){
    return ResponseEntity.ok().build();
  }

  @PutMapping("/sale/{number}")
  public ResponseEntity<?> putSale(){
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/sale/{number}")
  public ResponseEntity<?> deleteSale(){
    return ResponseEntity.ok().build();
  }

  @GetMapping("/sale/clothes/{number}")
  public ResponseEntity<List<DressDto>> getSaleClothes(
    @PathVariable Long number
  ){
    return ResponseEntity.ok(sales_service.getSaleClothes(number));
  }
}