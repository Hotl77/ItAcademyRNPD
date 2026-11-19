package org.hotl.resttemplatetesting;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Validated
@ConfigurationProperties(prefix = "app.seed")
public class SeedProperties {

    @NotBlank
    @Pattern(regexp = "https?://.+")
    private String uploadUrl;

    private Duration connectTimeout = Duration.ofSeconds(5);
    private Duration readTimeout = Duration.ofSeconds(30);
}
