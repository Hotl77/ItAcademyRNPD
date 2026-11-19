package org.hotl.resttemplatetesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RestTemplateTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateTestingApplication.class, args);
    }

}
