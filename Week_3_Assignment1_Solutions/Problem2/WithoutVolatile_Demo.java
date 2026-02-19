package Week_3_Assignment1_Solutions.Problem2;

class Counter {
     int count = 0;   // trying with volatile and without volatile
}

class IncrementThread extends Thread {
    Counter counter;

    IncrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            counter.count = i;
            System.out.println("Incremented to: " + i);
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

class ReadThread extends Thread {
    Counter counter;

    ReadThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        int localValue = counter.count;

        while (localValue < 5) {
            if (localValue != counter.count) {
                localValue = counter.count;
                System.out.println("Read value: " + localValue);
            }
        }
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // System.out.println("read value "+ counter.count);
    }
}

public class WithoutVolatile_Demo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new IncrementThread(counter).start();
        new ReadThread(counter).start();
    }
}
