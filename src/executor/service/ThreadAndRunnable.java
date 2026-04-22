package executor.service;

class RunnableInterface implements Runnable {

    @Override
    public void run() {
        System.out.println("This is from Runnable Interface: Thread 1");
    }
}

class ThreadClass extends Thread {

    @Override
    public void run() {
        System.out.println("This is from Thread extend class: Thread 2");
    }
}

public class ThreadAndRunnable {

    public static void main(String[] args) throws InterruptedException {

        // RunnableInterface runnable = new RunnableInterface();
        // Thread t1 = new Thread(runnable);

        Thread t1 = new Thread(new RunnableInterface());

        ThreadClass t2 = new ThreadClass();

        // proving implementation to run() via lambda expression
        Thread t3 = new Thread(() -> {
            System.out.println("Thread 3");
        });

        t1.start();
        t1.join(); // Main thread waits until Thread 1 finishes
        t2.start();
        t3.start();
    }
}