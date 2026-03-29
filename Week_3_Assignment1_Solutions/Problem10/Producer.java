package Week_3_Assignment1_Solutions.Problem10;

class Producer extends Thread {
    private final Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int value = 1;
        while (true) {
            buffer.produce(value++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
