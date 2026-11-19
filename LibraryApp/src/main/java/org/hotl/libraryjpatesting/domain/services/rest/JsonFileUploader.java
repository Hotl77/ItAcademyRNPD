package org.hotl.libraryjpatesting.domain.services.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotl.libraryjpatesting.properties.SeedProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;


@Slf4j
@Component
@RequiredArgsConstructor
public class JsonFileUploader {

    private final RestTemplate restTemplate;
    private final SeedProperties properties;
    private final ObjectMapper objectMapper;


    public String uploadUsersFromFile(MultipartFile file) {

        String rawJson = readFileAsString(file);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(rawJson, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    properties.getUploadUrl(), request, String.class
            );

            log.info("Файл загружен: статус = {}, ответ = {}",
                    response.getStatusCode(), response.getBody());

            return "status=" + response.getStatusCode() + ",created="
                    + countCreated(response.getBody());


        } catch (HttpClientErrorException | HttpServerErrorException e) {

            log.error("Сервер вернул ошибку: статус = {}, ответ = {}",
                    e.getStatusCode(), e.getResponseBodyAsString());


            throw new RuntimeException("Ошибка загрузки: " + e.getResponseBodyAsString(), e);
        }
    }

    private String readFileAsString(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new IllegalStateException("Файл не существует");
        }

        String content;

        try {
            content = new String(file.getBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException("Невозможно прочитать файл", e);
        }

        if (content.isBlank()) {
            throw new IllegalStateException("Загруженный файл пустой");
        }

        try {
            objectMapper.readTree(content);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Файл невалидного формата Json", e);
        }

        return content;
    }


    private int countCreated(String body) {
        if (body == null || body.isBlank()) return 0;
        try {
            JsonNode rootNode = objectMapper.readTree(body);


            if (rootNode.isArray()) {
                return rootNode.size();
            }


            JsonNode usersNode = rootNode.get("usersResponse");
            if (usersNode != null && usersNode.isArray()) {
                return usersNode.size();
            }

            return 1;
        } catch (JsonProcessingException e) {
            return 0;
        }
    }
}