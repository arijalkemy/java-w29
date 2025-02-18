package jpa_hibernate.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import jpa_hibernate.entities.MiniSeries;
import jpa_hibernate.services.MiniSeriesService;

@RestController
@RequiredArgsConstructor
public class MiniSeriesController {

  private final MiniSeriesService mini_series_service;
  
  @PostMapping("/miniseries")
  public ResponseEntity<?> createMiniSeries(@RequestBody MiniSeries mini_series) {
    mini_series_service.createMiniSeries(mini_series);
    return ResponseEntity.ok().build();
  }
}
