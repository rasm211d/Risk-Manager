package DBAccess;

import Logic.Risk;

import java.sql.*;

public class DBRisk {

    public static void main(String[] args) {

        createTable();

    }

    private static void createTable() {

        String sql = "CREATE TABLE IF NOT EXISTS risk (\n" +
                "id integer PRIMARY KEY AUTOINCREMENT, \n" +
                "description text NOT NULL, \n" +
                "probability real NOT NULL, \n" +
                "consequence real NOT NULL, \n" +
                "attachStrategy integer, \n" +
                "FOREIGN KEY(attachStrategy) REFERENCES strategy(id)" +
                ");";

        try (Connection conn = Connect.connect();
             Statement st = conn.createStatement()) {

            st.execute(sql);

        } catch (SQLException e) {
            e.getMessage();
        }

    }

    public static Risk getById(int id) {

        createTable();

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

                if (rs.getInt("attachedStrategy") != 0) {
                    risk.setAttachedStrategy(DBStrategy.getById(rs.getInt("id")));
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return risk;

    }

    public static void insert(Risk risk) {

        createTable();

        String sql = "INSERT INTO risk(description, probability, consequence) VALUES(?,?,?)";

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

        createTable();

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

        createTable();

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
