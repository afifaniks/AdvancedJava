package thread;

import static thread.ExtendedThread.sleep;

public class ThreadByRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()  + ": " +  i);
            sleep(500);
        }
    }

    public static void main(String[] args) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        ThreadByRunnable runnable = new ThreadByRunnable();
        Thread extendedThread = new Thread(runnable);
        extendedThread.setName("Runnable Thread");
        extendedThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            sleep(1000);
        }
    }
}
