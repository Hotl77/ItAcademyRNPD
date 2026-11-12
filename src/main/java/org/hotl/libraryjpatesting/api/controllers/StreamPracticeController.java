package org.hotl.libraryjpatesting.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/symbols")
public class StreamPracticeController {


    @GetMapping("/stream")
    public Map<Character, Integer> countSymbolsStream(@RequestParam String str){
        Map<Character,Integer> map = new HashMap<>();

        List<Character> list  = str.chars()
                .mapToObj(x -> (Character)((char)x))
                .collect(Collectors.toList());

        list.stream().
                forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));

        return map;

    }







}
