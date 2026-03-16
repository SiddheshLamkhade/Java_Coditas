package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {
    public void insertStudents(Connection con) throws Exception {

        String sql = "INSERT INTO student_source(id,name,age) VALUES(?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        for (int i = 1; i <= 10000; i++) {

            ps.setInt(1, i);
            ps.setString(2, "Student_" + i);
            ps.setInt(3, 20 + (i % 5));

            ps.executeUpdate();
        }

        System.out.println("10000 records inserted successfully");

        ps.close();
    }

}
