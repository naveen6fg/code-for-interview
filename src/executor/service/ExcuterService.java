package executor.service;

import java.util.concurrent.*;

class ThreadInterface implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Callable...........");
        return "Naveen K...";
    }
}

public class ExcuterService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(10);
        ExecutorService es1 = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 100; i++) {
            es.submit(() -> {
                int j = 1;
                j++;
                System.out.println(Thread.currentThread().getName());
            });
        }

        for (int i = 0; i < 10; i++) {
            Future<String> f = es.submit(new ThreadInterface());
            System.out.println(f.get());
        }

        es.shutdown();
        es1.shutdownNow();

        // only implementation of run() method via two way....
        // Anonymous class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello1");
            }
        };

        // Lambda expression
        Runnable r2 = () -> {
            System.out.println("Hello2");
        };

        new Thread(r1).start();
        new Thread(r2).start();

        // Implementation + thread start
        new Thread(() -> {
            System.out.println("Hi");
        }).start();
    }
}