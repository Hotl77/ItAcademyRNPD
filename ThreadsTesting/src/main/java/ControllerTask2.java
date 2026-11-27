
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task2")
public class ControllerTask2 {

    private final Task2 task2;


    @GetMapping("/start")
    public void startThreads(){

        task2.startThreadNum();
        task2.startThreadLiter();

    }

    @GetMapping("/result")
    public List<String> result()
    {
        Collection<String> col = task2.getSharedCollection();
        synchronized (col) {
            return new ArrayList<>(col);
        }

    }
}
