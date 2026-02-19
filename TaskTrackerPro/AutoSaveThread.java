package TaskTrackerPro;

class AutoSaveThread extends Thread {
    private TaskManager manager;

    public AutoSaveThread(TaskManager manager) {
        this.manager = manager;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30000); // 30 seconds
                manager.saveToFile();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}