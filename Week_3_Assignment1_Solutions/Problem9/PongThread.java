package Week_3_Assignment1_Solutions.Problem9;

class PongThread extends Thread {
    private final PingPong game;

    PongThread(PingPong game) {
        this.game = game;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            game.pong();
        }
    }
}

