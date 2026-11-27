import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Задача 4.
 * Есть очередь фиксированного размера (например, 5 элементов).
 * Один поток (Producer) добавляет в неё случайные числа,
 * другой (Consumer) их забирает и выводит на экран.
 */

public class Task4 {

    private static final int CAPACITY = 5;
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Random random = new Random();

        Thread producer = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int num = random.nextInt(100);
                    synchronized (queue) {
                        while (queue.size() == CAPACITY) {
                            System.out.println("Очередь полна. Producer ждёт...");
                            queue.wait();
                        }
                        queue.add(num);
                        System.out.println("Producer добавил: " + num + " | Размер: " + queue.size());
                        queue.notifyAll();
                    }
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (queue) {
                        while (queue.isEmpty()) {
                            System.out.println("Очередь пуста. Consumer ждёт...");
                            queue.wait();
                        }
                        int num = queue.poll();
                        System.out.println("Consumer забрал: " + num + " | Размер: " + queue.size());
                        queue.notifyAll();
                    }
                    Thread.sleep(700);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }

}
