package com.example.obrasliterarias.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.obrasliterarias.repository")
public class ElasticsearchConfig {
}
