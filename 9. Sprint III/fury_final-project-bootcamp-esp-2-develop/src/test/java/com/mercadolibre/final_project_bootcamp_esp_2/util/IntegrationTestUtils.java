package com.mercadolibre.final_project_bootcamp_esp_2.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class IntegrationTestUtils {
    @Value("${test.auth.supervisor-token}")
    private String supervisorToken;
    @Value("${test.auth.buyer-token}")
    private String buyerToken;

    public HttpHeaders generateAuthHeaderForSupervisor() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + supervisorToken);
        return headers;
    }

    public HttpHeaders generateAuthHeaderForBuyer() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + buyerToken);
        return headers;
    }

}
