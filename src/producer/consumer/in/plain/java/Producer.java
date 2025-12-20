package producer.consumer.in.plain.java;

public class Producer implements Runnable {

    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            try {
                buffer.produce(value++);
                Thread.sleep(100); // Simulate time taken to produce data
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
        }
    }
}
