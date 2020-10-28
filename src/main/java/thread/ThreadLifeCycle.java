package thread;

import java.util.concurrent.TimeUnit;

public class ThreadLifeCycle {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.setName("MyThread # 1");
        t1.start();

        Thread t2 = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("Running");
            }
        });

        t2.setName("MyThread # 2");
        t2.start();

        TimeUnit.MINUTES.sleep(5);
        t2.interrupt();
    }
}
