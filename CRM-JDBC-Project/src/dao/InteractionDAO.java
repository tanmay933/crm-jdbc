// InteractionDAO.java
package dao;

import model.Interaction;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InteractionDAO {

    public void addInteraction(Interaction i) {
        String sql = "INSERT INTO Interactions (account_id, type, details, interaction_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, i.getAccountId());
            stmt.setString(2, i.getType());
            stmt.setString(3, i.getDetails());
            stmt.setTimestamp(4, new Timestamp(i.getInteractionDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Interaction getInteractionById(int id) {
        String sql = "SELECT * FROM Interactions WHERE interaction_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Interaction(
                        rs.getInt("interaction_id"),
                        rs.getInt("account_id"),
                        rs.getString("type"),
                        rs.getString("details"),
                        rs.getTimestamp("interaction_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Interaction> getAllInteractions() {
        List<Interaction> list = new ArrayList<>();
        String sql = "SELECT * FROM Interactions";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Interaction(
                        rs.getInt("interaction_id"),
                        rs.getInt("account_id"),
                        rs.getString("type"),
                        rs.getString("details"),
                        rs.getTimestamp("interaction_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateInteraction(Interaction i) {
        String sql = "UPDATE Interactions SET account_id = ?, type = ?, details = ?, interaction_date = ? WHERE interaction_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, i.getAccountId());
            stmt.setString(2, i.getType());
            stmt.setString(3, i.getDetails());
            stmt.setTimestamp(4, new Timestamp(i.getInteractionDate().getTime()));
            stmt.setInt(5, i.getInteractionId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInteraction(int id) {
        String sql = "DELETE FROM Interactions WHERE interaction_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
