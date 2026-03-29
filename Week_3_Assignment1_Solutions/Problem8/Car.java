package Week_3_Assignment1_Solutions.Problem8;

class Car extends Thread {
    private final Tunnel tunnel;

    Car(Tunnel tunnel, String name) {
        super(name);
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        tunnel.passThrough(getName());
    }
}

