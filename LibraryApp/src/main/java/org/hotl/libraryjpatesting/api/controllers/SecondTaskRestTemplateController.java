package org.hotl.libraryjpatesting.api.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/reciever")
public class SecondTaskRestTemplateController {



    @PostMapping
    public String receiveMessage(@RequestBody String message) {
        if (message == null || message.trim().isEmpty()) {
            log.warn("Получено пустое сообщение или null");
            return "Ошибка: сообщение пустое!";
        }
        log.info("Пришло сообщение: '{}'", message);

        return "Все ок! Сообщение '" + message + "' успешно принято.";

    }

}
