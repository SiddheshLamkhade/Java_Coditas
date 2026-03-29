package Week_3_Assignment1_Solutions.Problem9;

class PingThread extends Thread {
    private final PingPong game;

    PingThread(PingPong game) {
        this.game = game;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            game.ping();
        }
    }
}

