package thread;

public class ExtendedThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("Extended: " + i);
            sleep(1000);
        }
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        ExtendedThread extendedThread = new ExtendedThread();
        extendedThread.setName("Extended Thread");
        extendedThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main: " + i);
            sleep(1000);
        }
    }
}

