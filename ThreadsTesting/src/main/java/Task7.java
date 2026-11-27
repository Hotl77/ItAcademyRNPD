import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Задача 7.
 * Имитируйте старт гонки. Создайте 5 потоков-«гонщиков».
 * Они должны дождаться команды «Старт» от главного потока,
 * одновременно начать работу и сообщить о финише.
 */



public class Task7 {

    public static void main(String[] args) throws InterruptedException {
        int racersCount = 5;

        CountDownLatch readyLatch = new CountDownLatch(racersCount);

        CountDownLatch startSignal = new CountDownLatch(1);

        CountDownLatch finishLatch = new CountDownLatch(racersCount);

        Random random = new Random();

        for (int i = 1; i <= racersCount; i++) {
            final int racerNumber = i;
            Thread racer = new Thread(() -> {
                try {
                    System.out.println("Гонщик #" + racerNumber + " подъехал к стартовой линии и готов.");
                    readyLatch.countDown();

                    startSignal.await();

                    System.out.println("Гонщик #" + racerNumber + " СТАРТОВАЛ!");
                    int raceTimeMs = 1000 + random.nextInt(2000);
                    Thread.sleep(raceTimeMs);

                    System.out.println("Гонщик #" + racerNumber + " ФИНИШИРОВАЛ за " + raceTimeMs + " мс!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    finishLatch.countDown();
                }
            });
            racer.start();
        }

        readyLatch.await();

        System.out.println("\nСудья: На старт! Внимание! МАРШ!\n");
        startSignal.countDown();

        finishLatch.await();
        System.out.println("\nСудья: Гонка завершена! Все участники на финише.");
    }





}
