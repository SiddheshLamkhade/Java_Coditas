import java.util.*;

public class NewThread implements Runnable {
    Sid jb;

    NewThread(Sid jb) {
        this.jb = jb;
    }

    @Override
    public void run() {
        jb.Hello();
    }
}
