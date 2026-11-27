
import java.util.ArrayList;
import java.util.List;

/**
 * Задача 3.
 * Создайте общий счетчик (переменную int). Запустите 10 потоков, каждый из
 * которых увеличивает этот счетчик на 1 в цикле (например, 1000 раз).
 * Цель: Увидеть, что итоговое значение будет меньше 10 000, и исправить
 * это с помощью synchronized или AtomicInteger.
 */

public class Task3 {

    private static int counter = 0;

    private static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<Thread>();

        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    for(int j = 0; j < 10000; j++){
                        counter++;
                    }

                }
            });
            threads.add(thread);
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Ожидалось: 100000");
        System.out.println("Получилось: " + counter);


    }
}




