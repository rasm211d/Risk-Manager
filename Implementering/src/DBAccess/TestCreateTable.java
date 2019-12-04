package DBAccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateTable {
    public static void main(String[] args) {

        String sql = "CREATE TABLE IF NOT EXISTS testTable (\n" +
                "id integer PRIMARY KEY,\n" +
                "name text NOT NULL,\n" +
                "number real NOT NULL\n" +
                ");";

        try (Connection conn = Connect.connect();
             Statement stmnt = conn.createStatement()) {
            stmnt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
