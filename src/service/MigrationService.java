package src.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MigrationService {
    public void migrateData(Connection con) throws Exception {

        String selectSQL = "SELECT * FROM student_source";

        String insertSQL = "INSERT INTO student_backup(id,name,age) VALUES(?,?,?)";

        PreparedStatement read = con.prepareStatement(selectSQL);

        PreparedStatement write = con.prepareStatement(insertSQL);

        ResultSet rs = read.executeQuery();

        int count = 0;

        while (rs.next()) {

            write.setInt(1, rs.getInt("id"));
            write.setString(2, rs.getString("name"));
            write.setInt(3, rs.getInt("age"));

            write.executeUpdate();

            count++;
        }

        System.out.println(count + " records copied successfully");

        rs.close();
        read.close();
        write.close();
    }
}
