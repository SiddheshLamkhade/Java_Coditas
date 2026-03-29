package Week_3_Assignment1_Solutions.Problem10;

public class ProducerConsumerDemo {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}

