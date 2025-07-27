// OpportunityDAO.java
package dao;

import model.Opportunity;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OpportunityDAO {

    public void addOpportunity(Opportunity opp) {
        String sql = "INSERT INTO Opportunities (account_id, stage, value, expected_close_date, created_at, closed) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, opp.getAccountId());
            stmt.setString(2, opp.getStage());
            stmt.setDouble(3, opp.getValue());
            stmt.setDate(4, new java.sql.Date(opp.getExpectedCloseDate().getTime()));
            stmt.setDate(5, new java.sql.Date(opp.getCreatedAt().getTime()));
            stmt.setBoolean(6, opp.isClosed());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Opportunity getOpportunityById(int id) {
        String sql = "SELECT * FROM Opportunities WHERE opportunity_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Opportunity(
                        rs.getInt("opportunity_id"),
                        rs.getInt("account_id"),
                        rs.getString("stage"),
                        rs.getDouble("value"),
                        rs.getDate("expected_close_date"),
                        rs.getDate("created_at"),
                        rs.getBoolean("closed")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Opportunity> getAllOpportunities() {
        List<Opportunity> list = new ArrayList<>();
        String sql = "SELECT * FROM Opportunities";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Opportunity(
                        rs.getInt("opportunity_id"),
                        rs.getInt("account_id"),
                        rs.getString("stage"),
                        rs.getDouble("value"),
                        rs.getDate("expected_close_date"),
                        rs.getDate("created_at"),
                        rs.getBoolean("closed")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateOpportunity(Opportunity opp) {
        String sql = "UPDATE Opportunities SET account_id = ?, stage = ?, value = ?, expected_close_date = ?, created_at = ?, closed = ? WHERE opportunity_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, opp.getAccountId());
            stmt.setString(2, opp.getStage());
            stmt.setDouble(3, opp.getValue());
            stmt.setDate(4, new java.sql.Date(opp.getExpectedCloseDate().getTime()));
            stmt.setDate(5, new java.sql.Date(opp.getCreatedAt().getTime()));
            stmt.setBoolean(6, opp.isClosed());
            stmt.setInt(7, opp.getOpportunityId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOpportunity(int id) {
        String sql = "DELETE FROM Opportunities WHERE opportunity_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
