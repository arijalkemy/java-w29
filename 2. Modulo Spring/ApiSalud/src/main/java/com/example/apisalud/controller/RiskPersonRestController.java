package com.example.apisalud.controller;

import com.example.apisalud.model.dto.response.RiskPersonResponse;
import com.example.apisalud.service.RiskPersonService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RiskPersonRestController {
    private final RiskPersonService riskPersonService;

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonResponse>> getAll() {
        return ResponseEntity.ok(riskPersonService.getAll());
    }
}
