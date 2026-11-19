package org.hotl.resttemplatetesting.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotl.resttemplatetesting.domain.RestTemplateProcessor;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/message")
public class SecondTaskRestTemplateController {

    private final RestTemplateProcessor restTemplateProcessor;


    @PostMapping
    public String sendMessage(
            @RequestBody RestTemplateTaskRequestDto requestDto
    ){
        return restTemplateProcessor.sendMessage(requestDto);
    }
}
