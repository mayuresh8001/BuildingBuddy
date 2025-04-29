package implementation;


import data.UserData;
import myProject.DBConnection;
import myProject.User;
import java.sql.*;

public class UserImpl implements UserData {
    @Override
    public boolean register(User user) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Register Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public User login(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                return user;
            }
        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());
        }
        return null;
    }
}
