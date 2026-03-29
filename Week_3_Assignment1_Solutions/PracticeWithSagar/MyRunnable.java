package Week_3_Assignment1_Solutions.PracticeWithSagar;

public class MyRunnable implements Runnable {
    String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("work started : : " + name);
        System.out.println("work finished : : " + name);
    }   

}
