package Week_3_Assignment1_Solutions.Problem9;

class PingPong {
    private boolean pingTurn = true;

    synchronized void ping() {
        try {
            while (!pingTurn) {
                wait();   // wait for Pong
            }
            System.out.println("Ping");
            pingTurn = false;
            notify();     // wake up Pong
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    synchronized void pong() {
        try {
            while (pingTurn) {
                wait();   // wait for Ping
            }
            System.out.println("Pong");
            pingTurn = true;
            notify();     // wake up Ping
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

