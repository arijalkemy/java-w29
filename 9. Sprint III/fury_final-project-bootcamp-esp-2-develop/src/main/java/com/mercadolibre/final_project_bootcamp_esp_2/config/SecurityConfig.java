package com.mercadolibre.final_project_bootcamp_esp_2.config;

import com.mercadolibre.final_project_bootcamp_esp_2.config.security.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider daoAuthProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        List<String> whitelistedUrls = List.of(
                "/ping",
                "/fake",
                "/user",
                "/auth/**",
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-ui.html"
        );

        List<String> supervisorUrls = List.of(
                "/api/v1/fresh-products/*/batch/list",
                "/api/v1/fresh-products/*/warehouse/list",
                "/api/v1/fresh-products/inboundorder",
                "/api/v1/fresh-products/batch/list/due-date/*",
                "/api/v1/fresh-products/*/products/*/stock"
        );
        List<String> buyerUrls = List.of(
                "/api/v1/fresh-products/list",
                "/api/v1/fresh-products/orders/**"
        );

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessMagConfig -> sessMagConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authReqConfig -> {
                    // Whitelisted URLs, allow anyone
                    authReqConfig
                            .requestMatchers(whitelistedUrls.toArray(new String[0]))
                            .permitAll();

                    // Access control for supervisor URLs
                    authReqConfig
                            .requestMatchers(supervisorUrls.toArray(new String[0]))
                            .hasAuthority("SUPERVISOR");

                    // Access control for buyer URLs
                    authReqConfig
                            .requestMatchers(buyerUrls.toArray(new String[0]))
                            .hasAuthority("BUYER");

                    authReqConfig.anyRequest().authenticated();
                })
                .build();
    }
}
