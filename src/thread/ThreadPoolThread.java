package thread;

import java.util.concurrent.*;

class ThreadPoolThread {

    private static int count = 1;
    private static final int MAX = 100;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int t = 0; t < 3; t++) {
            executor.submit(() -> {

                while (true) {
                    int num;

                    synchronized (ThreadPoolThread.class) {
                        if (count > MAX) return;
                        num = count++;
                    }

                    System.out.println(Thread.currentThread().getName() + " -> " + num);
                }

            });
        }

        executor.shutdown();
    }
}