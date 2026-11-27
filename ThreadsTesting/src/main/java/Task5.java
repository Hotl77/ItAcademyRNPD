/**
 * Задача 5.
 * Напишите программу, в которой два потока пытаются захватить
 * два разных монитора (объекта) в разном порядке. (1-2 2-1)
 */
public class Task5 {

        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();

        public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                synchronized (lock1) {
                    System.out.println("Поток 1: захватил lock1, жду lock2...");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    synchronized (lock2) {
                        System.out.println("Поток 1: захватил lock1 и lock2!");
                    }
                }
            });

            Thread thread2 = new Thread(() -> {
                synchronized (lock2) {
                    System.out.println("Поток 2: захватил lock2, жду lock1...");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    synchronized (lock1) {
                        System.out.println("Поток 2: захватил lock2 и lock1!");
                    }
                }
            });

            thread1.start();
            thread2.start();
        }

}
