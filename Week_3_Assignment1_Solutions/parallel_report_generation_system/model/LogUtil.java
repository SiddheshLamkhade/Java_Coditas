package Week_3_Assignment1_Solutions.parallel_report_generation_system.model;
import java.time.*;
public class LogUtil {

    public LogUtil() {
    }

    public static void log(String message) {
        System.out.println(
                "[" + LocalTime.now() + "] " +
                "[" + Thread.currentThread().getName() + "] " +
                message
        );
    }
}
