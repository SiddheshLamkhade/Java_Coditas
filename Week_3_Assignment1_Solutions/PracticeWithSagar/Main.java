package Week_3_Assignment1_Solutions.PracticeWithSagar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
   public static void main(String[] args) {
     ExecutorService executorService= Executors.newFixedThreadPool(5);
     for(int i=1; i<=20; i++){
        MyRunnable task=new MyRunnable("my thread"+ i);
        executorService.execute(task);
        
     }

   }

}


