package DBAccess;

import Logic.Strategy;

import java.sql.*;

public class DBStrategy {

    public static void main(String[] args) {
        createTable();
    }

    private static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS strategy (\n" +
                "id integer PRIMARY KEY AUTOINCREMENT, \n" +
                "description text NOT NULL, \n" +
                "cost real NOT NULL, \n" +
                "responsibility text NOT NULL, \n" +
                ");";

        try (Connection conn = Connect.connect();
            Statement st = conn.createStatement()) {

            st.execute(sql);

        }catch (SQLException e) {
            e.getMessage();
        }

    }

    public static Strategy getById(int id) {
        Strategy strategy = null;

        String sql = "SELECT * FROM strategy WHERE id = ?";

        try (Connection conn = Connect.connect();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                strategy = new Strategy(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getDouble("cost"),
                        rs.getString("responsibility")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return strategy;
    }


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

    public static void delete(Strategy strategy) {
        String sql = "DELETE FROM strategy WHERE id = ?";

        try (Connection conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, strategy.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
