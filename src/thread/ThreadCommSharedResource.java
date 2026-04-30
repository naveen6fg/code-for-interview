package thread;

class SharedResource {
    private int data;
    private boolean hasData = false;

    // Producer
    public synchronized void produce(char ch) throws InterruptedException {
        while (hasData) {
            wait(); // wait if data not consumed
        }


        System.out.println("Produced: " + ch);

        hasData = true;
        notify(); // notify consumer
    }

    // Consumer
    public synchronized void consume(int num) throws InterruptedException {
        while (!hasData) {
            wait(); // wait if no data
        }

        System.out.println("Consumed: " + num);

        hasData = false;
        notify(); // notify producer
    }
}
class Main {
        public static void main(String[] args) {

            SharedResource resource = new SharedResource();

            Thread producer = new Thread(() -> {
                try {
                    for (char i = 'a'; i <= 'z'; i++) {
                        resource.produce(i);
                    }
                } catch (Exception e) {}
            });

            Thread consumer = new Thread(() -> {
                try {
                    for (int i = 1; i <= 26; i++) {
                        resource.consume(i);
                    }
                } catch (Exception e) {}
            });

            producer.start();
            consumer.start();
        }
    }
