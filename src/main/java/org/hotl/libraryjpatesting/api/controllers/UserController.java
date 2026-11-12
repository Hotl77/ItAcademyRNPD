package org.hotl.libraryjpatesting.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotl.libraryjpatesting.api.dtos.json.JsonUsersResponseDto;
import org.hotl.libraryjpatesting.domain.services.JsonProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;


@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final JsonProcessor jsonProcessor;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public JsonUsersResponseDto createUsersAsJson(@RequestBody String rawData){
        JsonUsersResponseDto users = jsonProcessor.processAndSaveJson(rawData);
        return users;
    }

    @GetMapping(value = "/{id}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String getUserAsJson(@PathVariable UUID id){
        return jsonProcessor.getByIdAndSendRawJson(id);
    }
}
