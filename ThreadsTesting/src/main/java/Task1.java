import static java.lang.Thread.sleep;

/**
 * Задача 1.
 * Создайте два потока. Первый должен выводить в консоль числа
 * от 1 до 10 (цикл, со sleep/без sleep), а второй — буквы от A до J.
 */

public class Task1 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=1;i<=10;i++) {

                        System.out.printf("%s: %s%n", Thread.currentThread().getName(), i);

                        Thread.sleep(100);
                    }

                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread1.setPriority(10);

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for (char letter = 'A'; letter <= 'J'; letter++) {
                        System.out.printf("%s: %s%n", Thread.currentThread().getName(), letter);
                        Thread.sleep(100);
                    }

                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread2.setPriority(1);
        thread1.start();
        thread2.start();
    }
}
