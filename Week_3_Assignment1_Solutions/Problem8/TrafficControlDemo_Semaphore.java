package Week_3_Assignment1_Solutions.Problem8;

public class TrafficControlDemo_Semaphore {
    public static void main(String[] args) {

        Tunnel tunnel = new Tunnel();

        for (int i = 1; i <= 7; i++) {
            new Car(tunnel, "Car-" + i).start();
        }
        
    }
}

