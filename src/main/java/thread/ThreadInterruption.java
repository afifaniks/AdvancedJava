package thread;

import java.time.Instant;

public class ThreadInterruption extends Thread{
    private volatile boolean running = true;

    private void printDate() {
        System.out.println(Instant.now() + " in " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        while (running) {
            printDate();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown(){
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterruption threadInterruption = new ThreadInterruption();
        threadInterruption.setName("Thread 1");

        ThreadInterruption threadInterruption2 = new ThreadInterruption();
        threadInterruption2.setName("Thread 2");

        ThreadInterruption threadInterruption3 = new ThreadInterruption();
        threadInterruption3.setName("Thread 3");

        threadInterruption.start();
        threadInterruption2.start();
        threadInterruption3.start();

        Thread.sleep(10000);

        // Stopping
        threadInterruption.shutDown();
        threadInterruption2.shutDown();
        threadInterruption3.shutDown();
    }
}
