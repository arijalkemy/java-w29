package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.LoginRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.TokenResponse;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Buyer;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InternalUser;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IBuyerRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.InternalUserRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {
    private JwtUtil jwtUtil;
    private final IBuyerRepository buyerRepository;
    private InternalUserRepository internalUserRepository;

    public TokenResponse authenticate(LoginRequestDto request){
        Buyer buyer = buyerRepository.findByEmail(request.getEmail());
        if (buyer == null) {
            throw new NotFoundException("Buyer no encontrado.");
        }
        if (!buyer.getPassword().equals(request.getPassword())) {
            throw new NotFoundException("Password incorrecto.");
        }
        String token = jwtUtil.generateToken(buyer.getEmail());
        return new TokenResponse(token);
    }

    public InternalUser validateInternalUser(HttpServletRequest request){
        String token = jwtUtil.getToken(request);
        if (token == null) {
            throw new NotFoundException("No se encontró token.");
        }
        Claims user = jwtUtil.decodeToken(token);
        String username = user.get("sub", String.class);
        InternalUser internalUser = internalUserRepository.findByEmail(username);

        if (internalUser == null) {
            throw new NotFoundException("Usuario no encontrado.");
        }
        return internalUser;
    }

    public Buyer validateBuyer(HttpServletRequest request){
        String token = jwtUtil.getToken(request);
        if (token == null) {
            throw new NotFoundException("No se encontró token.");
        }
        Claims user = jwtUtil.decodeToken(token);
        String username = user.get("sub", String.class);
        Buyer buyer = buyerRepository.findByEmail(username);
        if (buyer == null) {
            throw new NotFoundException("Usuario no encontrado.");
        }
        return buyer;
    }
}
