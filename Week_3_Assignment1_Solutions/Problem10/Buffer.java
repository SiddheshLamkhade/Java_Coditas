package Week_3_Assignment1_Solutions.Problem10;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;

    synchronized void produce(int value){
        try {

            while (queue.size() == capacity) {
                System.out.println("Buffer full, Producer waiting...");
                wait();
            }

            queue.add(value);
            System.out.println("Produced: " + value);

            notify(); 
            // notify consumer

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    synchronized int consume() {
        int value = 0;
        try {
            while (queue.isEmpty()) {
                System.out.println(" Buffer empty, Consumer waiting. . .");
                wait();
            }

            value = queue.poll();
            System.out.println("Consumed: " + value);

            notify();
            // notify producer

        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return value;
    }
}

