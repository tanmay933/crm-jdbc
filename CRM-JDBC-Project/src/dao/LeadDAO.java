// LeadDAO.java
package dao;

import model.Lead;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeadDAO {

    public void addLead(Lead lead) {
        String sql = "INSERT INTO Leads (name, email, phone, created_at, converted, account_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lead.getName());
            stmt.setString(2, lead.getEmail());
            stmt.setString(3, lead.getPhone());
            stmt.setDate(4, new java.sql.Date(lead.getCreatedAt().getTime()));
            stmt.setBoolean(5, lead.isConverted());
            if (lead.getAccountId() != null) {
                stmt.setInt(6, lead.getAccountId());
            } else {
                stmt.setNull(6, Types.INTEGER);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Lead getLeadById(int id) {
        String sql = "SELECT * FROM Leads WHERE lead_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Lead(
                        rs.getInt("lead_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getDate("created_at"),
                        rs.getBoolean("converted"),
                        rs.getObject("account_id") != null ? rs.getInt("account_id") : null
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Lead> getAllLeads() {
        List<Lead> leads = new ArrayList<>();
        String sql = "SELECT * FROM Leads";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                leads.add(new Lead(
                        rs.getInt("lead_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getDate("created_at"),
                        rs.getBoolean("converted"),
                        rs.getObject("account_id") != null ? rs.getInt("account_id") : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leads;
    }

    public void updateLead(Lead lead) {
        String sql = "UPDATE Leads SET name = ?, email = ?, phone = ?, created_at = ?, converted = ?, account_id = ? WHERE lead_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lead.getName());
            stmt.setString(2, lead.getEmail());
            stmt.setString(3, lead.getPhone());
            stmt.setDate(4, new java.sql.Date(lead.getCreatedAt().getTime()));
            stmt.setBoolean(5, lead.isConverted());
            if (lead.getAccountId() != null) {
                stmt.setInt(6, lead.getAccountId());
            } else {
                stmt.setNull(6, Types.INTEGER);
            }
            stmt.setInt(7, lead.getLeadId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLead(int id) {
        String sql = "DELETE FROM Leads WHERE lead_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
