package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestWriteData {

    static void insert(String name, float number) {

        String sql = "INSERT INTO testTable(name, number) VALUES(?,?)";

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setFloat(2, number);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        insert("Benjamin", 48.29475982745F);
        insert("Rasmus", 21F);
    }
}
