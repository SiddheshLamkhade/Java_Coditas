import java.sql.*;

public class JDBC {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // loading the driver 
            //This driver is provided by MySQL Connector/J.
            //Modern JDBC (Java 6+) loads the driver automatically if the JAR is present. just writing below line



            Connection con = DriverManager.getConnection(     // preparing connection
                    "jdbc:mysql://localhost:3306/siddb",
                    "root",
                    "$idL@mkh@de.2");


            Statement st = con.createStatement();    // once connection is established we prepare a statement
            // Statement is used to send SQL queries to the database.  // Java → Statement → Database
            ResultSet rs = st.executeQuery("SELECT * FROM sid");  // and executes it
            // Alternatives to Statement : There are 3 main interfaces.
            /*
            Statement - Simple SQL execution.
            PreparedStatement - Precompiled SQL (most used).
            CallableStatement - Stored procedures.
            */


            // ResultSet stores the table data returned by the query.
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name"));
            }

            rs.close();
            st.close();
            con.close();
        } 
        
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
