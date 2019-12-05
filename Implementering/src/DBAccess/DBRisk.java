package DBAccess;

import Logic.Risk;
import Logic.Strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBRisk {

    public static void insert(Risk risk) {

        String sql = "INSERT INTO risk(description, probability, consequence) VALUES(?,?,?,?)";

        try (Connection conn = Connect.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, risk.getDescription());
            ps.setDouble(2, risk.getProbability());
            ps.setDouble(3, risk.getConsequence());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(Risk risk) {

        String sql = "UPDATE risk SET description = ? , " +
                "probability = ? , " +
                "consequence = ? , " +
                "attachedStrategy = ? " +
                "WHERE id = ?";

        try (Connection conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, risk.getDescription());
            ps.setDouble(2, risk.getProbability());
            ps.setDouble(3, risk.getConsequence());
            ps.setInt(4, risk.getAttachedStrategy().getId());
            ps.setInt(5, risk.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
