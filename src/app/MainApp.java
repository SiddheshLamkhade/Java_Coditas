package src.app;
import java.sql.Connection;
import src.dao.StudentDAO;
import src.db.DBConnection;
import src.service.MigrationService;

public class MainApp {
    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.println("Connected to database");

            StudentDAO dao = new StudentDAO();
            dao.insertStudents(con);

            System.out.println("Starting data migration...");

            MigrationService service = new MigrationService();

            service.migrateData(con);

            System.out.println("Process completed");

            con.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
