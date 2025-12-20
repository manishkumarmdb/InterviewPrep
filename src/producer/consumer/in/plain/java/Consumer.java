package producer.consumer.in.plain.java;

public class Consumer implements Runnable {

    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.consume();
                Thread.sleep(150); // Simulate time taken to consume data
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
