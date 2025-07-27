// TaskDAO.java
package dao;

import model.Task;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public void addTask(Task task) {
        String sql = "INSERT INTO Tasks (assigned_to, account_id, description, due_date, completed) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, task.getAssignedTo());
            if (task.getAccountId() != null) {
                stmt.setInt(2, task.getAccountId());
            } else {
                stmt.setNull(2, Types.INTEGER);
            }
            stmt.setString(3, task.getDescription());
            stmt.setDate(4, new java.sql.Date(task.getDueDate().getTime()));
            stmt.setBoolean(5, task.isCompleted());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Task getTaskById(int id) {
        String sql = "SELECT * FROM Tasks WHERE task_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Task(
                        rs.getInt("task_id"),
                        rs.getInt("assigned_to"),
                        rs.getObject("account_id") != null ? rs.getInt("account_id") : null,
                        rs.getString("description"),
                        rs.getDate("due_date"),
                        rs.getBoolean("completed")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Task> getAllTasks() {
        List<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM Tasks";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Task(
                        rs.getInt("task_id"),
                        rs.getInt("assigned_to"),
                        rs.getObject("account_id") != null ? rs.getInt("account_id") : null,
                        rs.getString("description"),
                        rs.getDate("due_date"),
                        rs.getBoolean("completed")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateTask(Task task) {
        String sql = "UPDATE Tasks SET assigned_to = ?, account_id = ?, description = ?, due_date = ?, completed = ? WHERE task_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, task.getAssignedTo());
            if (task.getAccountId() != null) {
                stmt.setInt(2, task.getAccountId());
            } else {
                stmt.setNull(2, Types.INTEGER);
            }
            stmt.setString(3, task.getDescription());
            stmt.setDate(4, new java.sql.Date(task.getDueDate().getTime()));
            stmt.setBoolean(5, task.isCompleted());
            stmt.setInt(6, task.getTaskId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int id) {
        String sql = "DELETE FROM Tasks WHERE task_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
