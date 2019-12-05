package DBAccess;

import Logic.Risk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBRisk {

    public static void insert(Risk risk) {

        String sql = "INSERT INTO risk(description, probability, consequence, exposure) VALUES(?,?,?,?)";

        try (Connection conn = Connect.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, risk.getDescription());
            ps.setDouble(2, risk.getProbability());
            ps.setDouble(3, risk.getConsequence());
            ps.setDouble(4, risk.getExposure());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
