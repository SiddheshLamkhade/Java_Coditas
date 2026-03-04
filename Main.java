import java.util.*;
public class Main {
    public static void main(String[] args) {
        OldThread oldThread = new OldThread();
        oldThread.start();
        Sid jb=new Sid();
        Thread t=new Thread(new NewThread(jb));
        t.startVirtualThread(t);

        // don't just mug the concepts.. Practice Codes 
    }
}
