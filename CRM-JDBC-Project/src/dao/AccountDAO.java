// AccountDAO.java
package dao;

import model.Account;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    public void addAccount(Account account) {
        String sql = "INSERT INTO Accounts (name, contact_email, contact_phone) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getName());
            stmt.setString(2, account.getContactEmail());
            stmt.setString(3, account.getContactPhone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account getAccountById(int id) {
        String sql = "SELECT * FROM Accounts WHERE account_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getInt("account_id"),
                        rs.getString("name"),
                        rs.getString("contact_email"),
                        rs.getString("contact_phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM Accounts";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("account_id"),
                        rs.getString("name"),
                        rs.getString("contact_email"),
                        rs.getString("contact_phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void updateAccount(Account account) {
        String sql = "UPDATE Accounts SET name = ?, contact_email = ?, contact_phone = ? WHERE account_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getName());
            stmt.setString(2, account.getContactEmail());
            stmt.setString(3, account.getContactPhone());
            stmt.setInt(4, account.getAccountId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int id) {
        String sql = "DELETE FROM Accounts WHERE account_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
