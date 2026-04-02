package Week2Assigment1.Problem8;
import java.io.Serializable;
public class
User implements Serializable {
    String username;
    transient final String password;   // will NOT be serialized
    String email;

    User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
