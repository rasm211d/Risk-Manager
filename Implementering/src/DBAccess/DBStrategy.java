package DBAccess;

import Logic.Strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBStrategy {

    public static void insert (Strategy strategy) {

        String sql = "INSERT INTO strategy(description, cost, responsibility) VALUES(?,?,?)";

        try (Connection conn = Connect.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, strategy.getDescription());
            ps.setDouble(2, strategy.getCost());
            ps.setString(3,strategy.getResponsibility());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(Strategy strategy) {
        String sql = "UPDATE strategy SET description = ? , " +
                "cost = ? , " +
                "responsibility = ? , " +
                "WHERE id = ?";

        try (Connection conn = Connect.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, strategy.getDescription());
            ps.setDouble(2, strategy.getCost());
            ps.setString(3, strategy.getResponsibility());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
