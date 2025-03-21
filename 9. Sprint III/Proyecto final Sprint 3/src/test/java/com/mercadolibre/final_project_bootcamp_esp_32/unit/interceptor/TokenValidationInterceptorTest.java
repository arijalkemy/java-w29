package com.mercadolibre.final_project_bootcamp_esp_32.unit.interceptor;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.Buyer;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.interceptor.TokenValidationInterceptor;
import com.mercadolibre.final_project_bootcamp_esp_32.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TokenValidationInterceptorTest {
    @Mock
    private AuthService authService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @InjectMocks
    private TokenValidationInterceptor tokenValidationInterceptor;

    private PrintWriter writer;

    @BeforeEach
    void setUp() throws IOException {
        // Inicializar mocks
        MockitoAnnotations.openMocks(this);
        writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    void testPreHandleWithValidToken() throws Exception {
        Buyer buyer = new Buyer();
        buyer.setId(1);
        // Simula que el servicio authService no lanza excepción al validar el token
        when(authService.validateBuyer(request)).thenReturn(buyer);

        boolean result = tokenValidationInterceptor.preHandle(request, response, new Object());

        // Verifica que el interceptor permite continuar la solicitud
        assertTrue(result);
        // Verifica que no se estableció ningún estado en la respuesta
        verify(response, never()).setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    @Test
    void testPreHandleWithInvalidToken() throws Exception {
        // Simula que el servicio authService lanza una excepción NotFoundException
        doThrow(new NotFoundException("Token inválido o no autorizado.")).when(authService).validateBuyer(request);

        boolean result = tokenValidationInterceptor.preHandle(request, response, new Object());

        // Verifica que el interceptor retorna 'false' y no permite continuar la solicitud
        assertFalse(result);

        // Verifica que se haya establecido el estado 403 y el mensaje de error correcto
        verify(response).setStatus(HttpServletResponse.SC_FORBIDDEN);
        verify(response.getWriter()).write("Token inválido o no autorizado.");
    }
}
