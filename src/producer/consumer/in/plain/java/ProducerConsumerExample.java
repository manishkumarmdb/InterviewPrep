package producer.consumer.in.plain.java;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(3);
        Thread pt1 = new Thread(new Producer(buffer));
        Thread pt2 = new Thread(new Producer(buffer));
        Thread pt3 = new Thread(new Producer(buffer));

        Thread ct1 = new Thread(new Consumer(buffer));
        Thread ct2 = new Thread(new Consumer(buffer));
        Thread ct3 = new Thread(new Consumer(buffer));

        // Start all the threads
        pt1.start();
        pt2.start();
        pt3.start();

        ct1.start();
        ct2.start();
        ct3.start();
    }
}
