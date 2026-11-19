package org.hotl.resttemplatetesting.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotl.resttemplatetesting.api.RestTemplateTaskRequestDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
@RequiredArgsConstructor
public class RestTemplateProcessor {

    private final RestTemplate restTemplate;

    public String sendMessage(RestTemplateTaskRequestDto requestDto) {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        HttpEntity<String> request = new HttpEntity<>(requestDto.text(), headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    requestDto.url(), request, String.class
            );

            log.info("Введенный текст отправлен: статус = {}, ответ = {}",
                    response.getStatusCode(), response.getBody());

            return "status from reciever=" + response.getStatusCode() + "message=" + response.getBody();


        } catch (HttpClientErrorException | HttpServerErrorException e) {

            log.error("Сервер вернул ошибку: статус = {}, ответ = {}",
                    e.getStatusCode(), e.getResponseBodyAsString());

            throw new RuntimeException("Ошибка загрузки: " + e.getResponseBodyAsString(), e);
        }
    }


}
