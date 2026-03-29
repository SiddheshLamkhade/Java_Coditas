package Week_3_Assignment1_Solutions.Problem5;

class Task implements Runnable {
    private final String taskName;

    Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(
            Thread.currentThread().getName() +
            " processing " + taskName
        );

        try {
            Thread.sleep(2000); // simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(
            Thread.currentThread().getName() +
            " completed " + taskName
        );
    }
}
