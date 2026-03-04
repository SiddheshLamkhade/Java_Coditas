package Week_4_Tasks.email;

public class EmailSender {

    public void sendEmail(String email) {
        try {
            Thread.sleep(1000); // Simulate email sending
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
