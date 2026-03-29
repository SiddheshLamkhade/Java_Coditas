package Week_3_Assignment1_Solutions.Problem7;
class Worker extends Thread {
    private final SharedResource resource;

    Worker(SharedResource resource, String name) {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.increment();
    }
}


