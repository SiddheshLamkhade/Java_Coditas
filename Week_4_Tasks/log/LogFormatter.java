package Week_4_Tasks.log;

public class LogFormatter {

    public static String formatLog(String user, String status) {

        return """
                ========================
                Application Log
                User: %s
                Status: %s
                ========================
                """.formatted(user, status);
    }

    public static void main(String[] args) {
        String log = formatLog("XYZ", "SUCCESS");
        System.out.println(log);
    }
}