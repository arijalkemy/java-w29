package com.mercadolibre.final_project_bootcamp_esp_32.config;

import com.mercadolibre.secretclient.SecretClient;
import com.mercadolibre.secretclient.SecretClientBuilder;
import org.springframework.context.annotation.Bean;

public class SecretConfig {
    private final Integer timeout = 9000;

    @Bean
    public SecretClient secretClient(){
        return SecretClientBuilder.builder().client().withRequestTimeout(timeout)
                .build();
    }
}
