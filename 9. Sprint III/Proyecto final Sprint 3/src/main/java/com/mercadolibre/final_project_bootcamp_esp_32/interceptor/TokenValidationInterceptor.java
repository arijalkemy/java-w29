package com.mercadolibre.final_project_bootcamp_esp_32.interceptor;

import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class TokenValidationInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    @Autowired
    public TokenValidationInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            authService.validateBuyer(request);
        } catch (NotFoundException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Token inválido o no autorizado.");
            return false;
        }
        return true;
    }
}

