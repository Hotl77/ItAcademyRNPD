package org.hotl.libraryjpatesting.domain.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotl.libraryjpatesting.api.dtos.json.JsonUserRequestDto;
import org.hotl.libraryjpatesting.api.dtos.json.JsonUserResponseDto;
import org.hotl.libraryjpatesting.api.dtos.json.JsonUsersRequestDto;
import org.hotl.libraryjpatesting.api.dtos.json.JsonUsersResponseDto;
import org.hotl.libraryjpatesting.api.mappers.UserEntityMapper;
import org.hotl.libraryjpatesting.domain.entities.UserEntity;
import org.hotl.libraryjpatesting.domain.jpas.UserEntityJpa;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Service
public class JsonProcessor {

    final UserEntityJpa userRepository;
    final UserEntityMapper userEntityMapper;

    private static final ObjectMapper objectMapper = JsonMapper.builder()
            // Пример 1: Разрешаем игнорировать поля в JSON, которых нет в DTO (чтобы не падал)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            // Пример 2: Разрешаем пустые строки превращать в null
            .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
            // Пример 3: Принудительно делаем все поля обязательными, если они примитивы (не объекты)
            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
            //подключаем поддержку java.time (LocalDate, LocalDateTime, Instant, ...)
            .addModule(new JavaTimeModule())
            //Не сериализовать даты в виде чисел (timestamps), а писать ISO-8601 строкой
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .build();

    @Transactional
    public JsonUsersResponseDto processAndSaveJson(String rawJson) {

        JsonUsersRequestDto listOfUsersDto;

        try {

            listOfUsersDto = objectMapper.readValue(rawJson, JsonUsersRequestDto.class);

        }
        catch (JsonProcessingException e) {
            log.error("Ошибка парсинга JSON: {}", e.getOriginalMessage());
            throw new IllegalArgumentException("Некорректный JSON: " + e.getOriginalMessage(), e);
        }

        if (listOfUsersDto == null || listOfUsersDto.usersRequest() == null || listOfUsersDto.usersRequest().isEmpty()) {
            throw new IllegalArgumentException("JSON не содержит данных о пользователях");
        }

        List<JsonUserRequestDto> users = listOfUsersDto.usersRequest();


        List<UserEntity> userEntities = userEntityMapper.toUserEntities(users);
        userRepository.saveAll(userEntities);

        List<JsonUserResponseDto> userResponseList = userEntityMapper.toJsonUsersResponseDto(userEntities);


        JsonUsersResponseDto usersResponse = new JsonUsersResponseDto(userResponseList);


        return usersResponse;

    }

    @Transactional(readOnly = true)
    public String getByIdAndSendRawJson(UUID id){

        UserEntity user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found: " + id));;

        JsonUserResponseDto userDto = userEntityMapper.toJsonUser(user);

        String rawData = "";

        try{
            rawData = objectMapper.writeValueAsString(userDto);

        }
        catch (Exception e){
            throw new RuntimeException("Error processing Entity data", e);
        }

        return rawData;

    }









}
