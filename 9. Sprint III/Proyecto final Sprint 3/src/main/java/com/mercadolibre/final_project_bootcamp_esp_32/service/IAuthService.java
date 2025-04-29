package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.LoginRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.TokenResponse;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Buyer;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InternalUser;
import jakarta.servlet.http.HttpServletRequest;

public interface IAuthService {
    TokenResponse authenticate(LoginRequestDto request);
    InternalUser validateInternalUser(HttpServletRequest request);
    Buyer validateBuyer(HttpServletRequest request);
}
