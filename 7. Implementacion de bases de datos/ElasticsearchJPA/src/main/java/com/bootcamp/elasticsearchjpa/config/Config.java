package com.bootcamp.elasticsearchjpa.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories
public class Config {

    @Bean
    public RestClient restClient() {
        return RestClient
                .builder(new HttpHost("localhost", 9200, "http"))
                .build();
    }

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        RestClientTransport transport = new RestClientTransport(restClient(), new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }

}
