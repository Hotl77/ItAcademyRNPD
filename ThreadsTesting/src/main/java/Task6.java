import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Задача 6.
 * Дан массив из 1000 чисел. Нужно вычислить сумму всех элементов,
 * разделив массив на 10 частей и обрабатывая каждую часть в
 * отдельном потоке через FixedThreadPool.
 */

public class Task6 {

    public static void main(String[] args){

        int[] array = new int[1000];
        Arrays.fill(array, 1);

        int cores = Runtime.getRuntime().availableProcessors();
        int threadCount = cores;
        int chunkSize = array.length / threadCount;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Future<Long>> futures = new ArrayList<>();

        try {
            for (int i = 0; i < threadCount; i++) {
                final int start = i * chunkSize;
                final int end = (i == threadCount - 1) ? array.length : start + chunkSize;

                Callable<Long> task = () -> {
                    long partialSum = 0;
                    for (int j = start; j < end; j++) {
                        partialSum += array[j];
                    }
                    System.out.printf("%s посчитал участок [%d..%d): %d%n",
                            Thread.currentThread().getName(), start, end, partialSum);
                    return partialSum;
                };

                futures.add(executor.submit(task));
            }

            long totalSum = 0;
            for (Future<Long> future : futures) {
                totalSum += future.get();
            }

            System.out.println("Итоговая сумма: " + totalSum);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt(); // Обязательно возвращаем флаг прерывания!
            System.out.println("Ожидание результата задачи было прервано" + e);

    } catch (ExecutionException e) {
            System.out.println("Ошибка при выполнении фоновой задачи: {}"+ e.getCause().getMessage() + e.getCause());
        throw new IllegalStateException("Не удалось выполнить расчёт", e.getCause());

    } catch (CancellationException e) {

            System.out.println("Задача была отменена до завершения");
    }
        finally {
            executor.shutdown();
        }

    }
}
