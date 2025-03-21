package com.mercadolibre.final_project_bootcamp_esp_32.config;

import com.mercadolibre.final_project_bootcamp_esp_32.interceptor.TokenValidationInterceptor;
import com.mercadolibre.routing.RoutingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  /**
   * Gets the router filter.
   * 
   * @return the router filter
   */
  private final TokenValidationInterceptor tokenValidationInterceptor;

  @Autowired
  public WebConfig(TokenValidationInterceptor tokenValidationInterceptor) {
    this.tokenValidationInterceptor = tokenValidationInterceptor;
  }

  @Bean
  public FilterRegistrationBean<RoutingFilter> routingFilter() {
    FilterRegistrationBean<RoutingFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setName("routingFilter");
    registrationBean.setFilter(new RoutingFilter());
    registrationBean.setOrder(1);
    return registrationBean;
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new FixedLocaleResolver(Locale.US);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(tokenValidationInterceptor)
            .addPathPatterns("/api/v1/fresh-products/orders/**")
            .addPathPatterns("/api/v1/fresh-products/list");
  }

}
