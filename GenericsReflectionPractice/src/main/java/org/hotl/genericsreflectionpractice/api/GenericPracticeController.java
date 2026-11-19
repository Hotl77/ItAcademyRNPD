package org.hotl.genericsreflectionpractice.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotl.genericsreflectionpractice.domain.GenericService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/generics")
public class GenericPracticeController {


    private final GenericService genericService;


    @PostMapping("/sorting")
    public String sortMassiveGeneric(@RequestBody String text){
        return genericService.sortMassive(text);
    }

    @PostMapping("/searching")
    public String searchItemInMassiveGeneric(@RequestBody SearchRequest searchRequest){
        return genericService.findItem(searchRequest);
    }


}
