package hql.showroom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "hql.showroom.repository.elasticsearch")
public class ElasticsearchConfig {
}
