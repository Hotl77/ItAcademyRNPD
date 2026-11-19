package org.hotl.libraryjpatesting.api.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotl.libraryjpatesting.domain.services.rest.JsonFileUploader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/json")
public class SendJsonController {

    final JsonFileUploader jsonFileUploader;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String sendFileAsJson(@RequestParam("file") MultipartFile file) {
        return jsonFileUploader.uploadUsersFromFile(file);
    }



}
