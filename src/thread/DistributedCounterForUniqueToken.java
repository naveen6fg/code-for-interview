package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class DistributedCounterForUniqueToken {

  //  private static int x = 1;
    private static final AtomicInteger getInteger = new AtomicInteger(1);


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            int counterId = i;
            Thread t1 = new Thread(() -> {
                int token = genrateToken();
                System.out.println("Counter :" + counterId + " token :" + token);
            });
            t1.start();
        }
    }


    //private  synchronized static int genrateToken()  {
    private  static int genrateToken()  {

        try {
            Thread.sleep(1500);
        }catch (InterruptedException e){
            System.out.println( e.getMessage());
        }
        //return x++;
      return getInteger.getAndIncrement();
    }
}
