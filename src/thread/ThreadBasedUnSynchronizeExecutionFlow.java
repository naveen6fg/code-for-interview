package thread;

public class ThreadBasedUnSynchronizeExecutionFlow {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            boilWater();
        });
        Thread t2 = new Thread(() -> {
            brewCoffee();
        });
        Thread t3 = new Thread(() -> {
            makeCoffee();
        });

        t1.start();
        t2.start();
        t3.start();
        System.err.println("End Of Main Thread : " + Thread.currentThread().getName());
    }

    public static void boilWater() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - Boiling Water..!! at " + System.currentTimeMillis());
    }

    public static void brewCoffee() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " -Crushing/Brewing. coffee.!! at " + System.currentTimeMillis());
    }

    public static void makeCoffee() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " -Mixing both and make coffee.. At " + System.currentTimeMillis());

    }
}
