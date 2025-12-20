package producer.consumer.in.plain.java;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    // Method to add data to the buffer
    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(value);
        System.out.println("Produced : " + value);
        notify(); // Notify consumers that there's data available
    }

    // Method to retrieve data from the buffer
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int value = queue.remove();
        System.out.println("Consumed : " + value);
        notify(); // Notify producers that there's space available

        return value;
    }
}
