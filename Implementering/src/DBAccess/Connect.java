package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connect() {

        // Connection string
        String url = "jdbc:sqlite:db/data.db";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Connection to db failed.");
        }
    }
}
