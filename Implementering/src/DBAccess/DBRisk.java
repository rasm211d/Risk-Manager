package DBAccess;

import Logic.Risk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBRisk {

    public static void Insert(Risk risk) {

        String sql = "INSERT INTO risk(description, probability, consequence, exposure, attachedStrategyId) VALUES(?,?,?,?,?)";

        try (Connection conn = Connect.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, risk.getDescription);
            ps.setFloat(2, risk.getProbability);
            ps.setFloat(3, consequence);
            ps.setFloat(4, exposure);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
