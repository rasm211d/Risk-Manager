package DBAccess;

import Logic.Risk;
import Logic.Strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBRisk {

    public static Risk getById(int id) {

        Risk risk = null;

        String sql = "SELECT * FROM risk WHERE id = ?";

        try (Connection conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                risk = new Risk(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getDouble("probability"),
                        rs.getDouble("consequence")
                );

                // TODO: get strategy from db attachedStrategy id and update local risk object

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return risk;

    }

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

    public static void delete(Risk risk) {

        String sql = "DELETE FROM risk WHERE id = ?";

        try (Connection conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, risk.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}