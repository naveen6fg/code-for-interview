package executor.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread implements Runnable {

    volatile boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("Inside while....." + i++);
        }
    }
}

public class VolatileKeywordAndAtomicity {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();

        MyThread t1 = new MyThread();

        new Thread(t1).start();

        Thread.sleep(1000);

        t1.flag = false;
    }
}