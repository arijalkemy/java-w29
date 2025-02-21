package ejercicios_extra_p2.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicios_extra_p2.dtos.SaleDto;
import ejercicios_extra_p2.services.ISalesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SalesController {
  private final ISalesService sales_service;

  @PostMapping("/sales")
  public ResponseEntity<?> postSale(
    @RequestBody SaleDto sale_dto
  ) throws URISyntaxException {
    String id = sales_service.saveSale(sale_dto);
    return ResponseEntity.created(new URI("/api/sales/"+id)).build();
  }

  @GetMapping("/sales")
  public ResponseEntity<List<SaleDto>> getSales(){
    return ResponseEntity.ok(sales_service.getSales());
  }

  @GetMapping("/sales/{id}")
  public ResponseEntity<SaleDto> getSale(
    @PathVariable String id
  ){
    return ResponseEntity.ok(sales_service.getSaleById(id));
  }
}
