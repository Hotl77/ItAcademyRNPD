import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Задача 2.
 * Используйте SynchronizedCollection типизированной строкой - каждый элемент
 * будет имя_потока_сгенерированный_элемент, сделать метод контроллера, который возращает
 * эту коллекцию - можно сделать при этом циклы в потоках бесконечные - с тем чтоб глазком
 * глянуть как система передает потокам управление.
 * Метод Контроллера1 – запускает два треда, каждый из которых пушит в коллекцию свое имя (треда/потока)
 *  и итерацию выполнения тела цикла (num). Другой метод контроллера - возвращает эту коллекцию.
 */



@Component
public class Task2 {

    @Getter
    private final Collection<String> sharedCollection =
            Collections.synchronizedCollection(new ArrayList<>());


    public void startThreadNum(
    ){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 1;
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String item = Thread.currentThread().getName() + "_" + num++;
                        sharedCollection.add(item);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
        );
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

    }


    public void startThreadLiter(

    ){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 1;
                char letter = 'A';
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String item = Thread.currentThread().getName() + "_" + letter + num++;
                        sharedCollection.add(item);
                        letter = (letter == 'J') ? 'A' : (char) (letter + 1);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
        );
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();

    }
}
