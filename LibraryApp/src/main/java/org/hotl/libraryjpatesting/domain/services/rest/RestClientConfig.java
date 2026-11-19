package org.hotl.libraryjpatesting.domain.services.rest;

import lombok.RequiredArgsConstructor;
import org.hotl.libraryjpatesting.properties.SeedProperties;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Configuration
public class RestClientConfig {

    private final SeedProperties seedProperties;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .connectTimeout(seedProperties.getConnectTimeout())
                .readTimeout(seedProperties.getReadTimeout())
                .build();
    }
}