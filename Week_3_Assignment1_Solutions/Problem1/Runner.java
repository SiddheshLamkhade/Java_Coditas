package Week_3_Assignment1_Solutions.Problem1;

class Runner implements Runnable {

    private String name;
    private static boolean raceFinished = false;
    private static final int FINISH_LINE = 10;

    public Runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int step = 1; step <= FINISH_LINE; step++) {

            // Stop if race already finished
            if (raceFinished) {
                return;
            }

            System.out.println(name + " ran step " + step);

            // If this runner finishes first
            if (step == FINISH_LINE) {
                raceFinished = true;
                System.out.println(name + " WON THE RACE!");
                return;
            }

            try {
                Thread.sleep(5800); // simulate running
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

