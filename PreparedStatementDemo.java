import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // loading the driver

            Connection con = DriverManager.getConnection( // preparing connection
                    "jdbc:mysql://localhost:3306/siddb",
                    "root",
                    "$idL@mkh@de.2");

            // Statement st = con.createStatement();
            // ResultSet rs = st.executeQuery("SELECT * FROM sid"); // and executes it

            // Alternatives to Statement : There are 3 main interfaces.
            /*
             * Statement - Simple SQL execution.
             * PreparedStatement - Precompiled SQL (most used).
             * CallableStatement - Stored procedures.
             */

            // 1️⃣ PreparedStatement (Most important) - Better than Statement.
            String sql = "SELECT * FROM sid WHERE id=?";
            String sql2 = "SELECT * FROM sid WHERE id=? AND name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps.setInt(1, 2);
            ps2.setInt(1, 3);
            ps2.setString(2, "ram");
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            /*
             * PreparedStatement mainly has three execution methods.
             * executeQuery() - Used for SELECT
             * ResultSet rs = ps.executeQuery();
             * Returns a ResultSet.
             * 
             * executeUpdate()- Used for INSERT / UPDATE / DELETE
             * int rows = ps.executeUpdate();
             * Returns number of rows affected.
             * 
             * execute() -General-purpose method.
             * ps.execute();
             * Returns boolean.
             * 
             * String sql = "INSERT INTO sid(id,name) VALUES (?,?)";
             * 
             * PreparedStatement ps = con.prepareStatement(sql);
             * 
             * ps.setInt(1,5);
             * ps.setString(2,"Siddhesh");
             * 
             * ps.executeUpdate();
             */

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name"));

            }
            while (rs2.next()) {
                System.out.println(
                        rs2.getInt("id") + " " +
                                rs2.getString("name"));
                            

            }

            rs.close();
            rs2.close();
            ps.close();
            ps2.close();
            con.close();

        }

        catch (Exception e) {
            System.out.println(e);
        }

    }
}
