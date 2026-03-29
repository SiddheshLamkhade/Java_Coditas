package Week_3_Assignment1_Solutions.Problem7;

public class ReentrantLockDemo {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread t1 = new Worker(resource, "Thread-1");
        Thread t2 = new Worker(resource, "Thread-2");
        Thread t3 = new Worker(resource, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

