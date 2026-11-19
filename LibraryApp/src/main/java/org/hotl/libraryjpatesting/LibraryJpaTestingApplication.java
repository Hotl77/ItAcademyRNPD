package org.hotl.libraryjpatesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LibraryJpaTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryJpaTestingApplication.class, args);
    }

}
