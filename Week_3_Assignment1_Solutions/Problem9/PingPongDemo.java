package Week_3_Assignment1_Solutions.Problem9;

public class PingPongDemo {
    public static void main(String[] args) {

        PingPong game = new PingPong();

        new PingThread(game).start();
        new PongThread(game).start();
    }
}

