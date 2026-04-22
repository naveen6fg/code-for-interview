package thread;

 class ThreadBasedSynchronizeExecutionFlow {

    public static void main(String[] args) {

        // Define the threads
        Thread t1 = new Thread(() -> {
            boilWater();
        });
        Thread t2 = new Thread(() -> {
            brewCoffee();
        });
        Thread t3 = new Thread(() -> {
            makeCoffee();
        });

        try {
            // Start t1 and wait for it to complete
            t1.start();
            t1.join();

            // Start t2 and wait for it to complete
            t2.start();
            t2.join();

            // Start t3 and wait for it to complete
            t3.start();
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End Of Main Thread : " + Thread.currentThread().getName());
    }

    public static void boilWater() {
        try {
            Thread.sleep(1000); // Simulate boiling water
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - Boiling Water..!! at " + System.currentTimeMillis());
    }

    public static void brewCoffee() {
        try {
            Thread.sleep(1000); // Simulate brewing coffee
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - Crushing/Brewing coffee..!! at " + System.currentTimeMillis());
    }

    public static void makeCoffee() {
        try {
            Thread.sleep(1000); // Simulate making coffee
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - Mixing both and making coffee.. at " + System.currentTimeMillis());
    }
}
