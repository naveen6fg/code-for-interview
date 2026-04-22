package thread;

import java.util.concurrent.CompletableFuture;

public class CompletebaleFutureOrAsynchronousExecution {


    public static void main(String[] args) {

        CompletableFuture boilWaterFuture = CompletableFuture.runAsync(() ->
                boilWater()).
                thenRun(() -> System.out.println("Water is ready ..!"));

        CompletableFuture brewCoffeeFuture = CompletableFuture.runAsync(() ->
                brewCoffee()).
                thenRun(() -> System.out.println("Brewing is ready ..!"));


        //Combine both operation
        CompletableFuture.allOf(boilWaterFuture, brewCoffeeFuture)
                .thenRun(() -> {
                    makeCoffee();
                    System.err.println("Coffee is ready ..!");
                });

        // wait for completetion

        System.out.println("Doing other task while coffee is being mad ..!! "+Thread.currentThread().getName() );

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void boilWater() {

        System.out.println("- Boiling Water..!! at " + System.currentTimeMillis());
    }

    public static void brewCoffee() {

        System.out.println(" -Crushing/Brewing. coffee.!! at " + System.currentTimeMillis());
    }

    public static void makeCoffee() {

        System.out.println(" -Mixing both and make coffee.. At " + System.currentTimeMillis());

    }
}
